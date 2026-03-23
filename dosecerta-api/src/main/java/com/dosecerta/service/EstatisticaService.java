package com.dosecerta.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;

import com.dosecerta.config.DatabaseConnection;
import com.dosecerta.dao.PacienteDAO;
import com.dosecerta.model.PacienteModel;

public class EstatisticaService {

    private PacienteDAO pacienteDAO = new PacienteDAO();
    private DatabaseConnection db = new DatabaseConnection();

    //CONVERSOR QUE CALCULA IDADE DE LOCALDATA PARA MESES
    public int calcularIdadeEmMeses(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimento, hoje);

        return periodo.getYears() * 12 + periodo.getMonths();
    }

    // TOTAL DE VACINAS APLICADAS POR ID PACIENTE
    public int totalPorPaciente(int idPaciente) throws Exception{
        String sql = "SELECT COUNT(*) FROM imunizacoes WHERE id_paciente=?";

        try (Connection c = db.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt(1);
        }

        return 0;
    }

    //VACINAS APLICAVEIS NO PROXIMO MES POR ID PACIENTE
    public int proximasPaciente(int idPaciente) throws Exception{
        
        // 1. Buscar paciente
        PacienteModel paciente = pacienteDAO.buscarPorId(idPaciente)
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        // 2. Calcular idade
        int idadeAtual = calcularIdadeEmMeses(paciente.getData_nascimento());
        int proximoMes = idadeAtual + 1;

        String sql = """
            SELECT COUNT(d.id_dose)
            FROM dose d
            JOIN vacina v ON v.id_vacina = d.id_vacina
            WHERE d.idade_recomendada_aplicacao = ?

            AND d.id_dose NOT IN (
                SELECT i.id_dose
                FROM imunizacoes i
                WHERE i.id_paciente = ?
            )

            AND (
                v.limite_aplicacao IS NULL
                OR v.limite_aplicacao >= ?
            )
        """;

        try (Connection c = db.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, proximoMes);
            ps.setInt(2, idPaciente);
            ps.setInt(3, proximoMes);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt(1);
        }

        return 0;
    }

    //VACINAS ATRASADAS
    public int vacinasAtrasadas(int id_paciente) throws Exception {

        // 1. Buscar paciente
        PacienteModel paciente = pacienteDAO.buscarPorId(id_paciente)
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        // 2. Calcular idade atual
        int idadeAtual = calcularIdadeEmMeses(paciente.getData_nascimento());

        String sql = """
            SELECT COUNT(d.id_dose)
            FROM dose d
            JOIN vacina v ON v.id_vacina = d.id_vacina

            WHERE d.idade_recomendada_aplicacao < ?

            -- NÃO foi aplicada
            AND d.id_dose NOT IN (
                SELECT i.id_dose
                FROM imunizacoes i
                WHERE i.id_paciente = ?
            )

            -- respeitar limite da vacina
            AND (
                v.limite_aplicacao IS NULL
                OR v.limite_aplicacao >= ?
            )
        """;

        try (Connection c = db.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idadeAtual);
            ps.setInt(2, id_paciente);
            ps.setInt(3, idadeAtual);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt(1);
        }

        return 0;
    }

    //QTE DE VACINAS COM RECOMENDACAO ACIMA DE UMA DETERMINADA IDADE
    public int vacinasAcimaDeIdade(int meses) throws Exception {

    String sql = """
        SELECT COUNT(id_dose)
        FROM dose
        WHERE idade_recomendada_aplicacao > ?
    """;

    try (Connection c = db.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {

        ps.setInt(1, meses);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) return rs.getInt(1);
    }

    return 0;
}


}
