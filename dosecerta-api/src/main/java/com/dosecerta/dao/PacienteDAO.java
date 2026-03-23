package com.dosecerta.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dosecerta.config.DatabaseConnection;
import com.dosecerta.model.PacienteModel;

@Repository
public class PacienteDAO {

    //CONEXAO AO BANCO
    private DatabaseConnection db = new DatabaseConnection();

    //---CONTRATOS---

    //INSERIR 
    public int inserir(PacienteModel p) throws SQLException {
        String sql = "INSERT INTO paciente (nome_paciente, cpf_paciente, sexo, data_nascimento) VALUES (?, ?, ?, ?)";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, p.getNome_paciente());
            stmt.setString(2, p.getCpf_paciente());
            stmt.setString(3, p.getSexo().toString());
            stmt.setDate(4, Date.valueOf(p.getData_nascimento()));

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }
        return 0;
    }

    //BUSCAR POR ID
    public Optional<PacienteModel> buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM paciente WHERE id_paciente=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new PacienteModel(
                        rs.getInt("id_paciente"),
                        rs.getString("nome_paciente"),
                        rs.getString("cpf_paciente"),
                        PacienteModel.Sexo.valueOf(rs.getString("sexo")),
                        rs.getDate("data_nascimento").toLocalDate()
                ));
            }
        }
        return Optional.empty();
    }

    //LISTAR
    public List<PacienteModel> listar() throws SQLException {
        List<PacienteModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PacienteModel p = new PacienteModel(
                        rs.getInt("id_paciente"),
                        rs.getString("nome_paciente"),
                        rs.getString("cpf_paciente"),
                        PacienteModel.Sexo.valueOf(rs.getString("sexo")),
                        rs.getDate("data_nascimento").toLocalDate()
                );
                lista.add(p);
            }
        }
        return lista;
    }

    //ATUALIZAR
    public boolean atualizar(int id, PacienteModel p) throws SQLException {
        String sql = "UPDATE paciente SET nome_paciente=?, cpf_paciente=?, sexo=?, data_nascimento=? WHERE id_paciente=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome_paciente());
            stmt.setString(2, p.getCpf_paciente());
            stmt.setString(3, p.getSexo().toString());
            stmt.setDate(4, Date.valueOf(p.getData_nascimento()));
            stmt.setInt(5, id);

            return stmt.executeUpdate() > 0;
        }
    }

    //DELETAR
    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM paciente WHERE id_paciente=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

}