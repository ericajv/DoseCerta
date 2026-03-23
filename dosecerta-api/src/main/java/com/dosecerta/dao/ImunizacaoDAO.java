package com.dosecerta.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dosecerta.config.DatabaseConnection;
import com.dosecerta.model.ImunizacaoModel;

@Repository
public class ImunizacaoDAO {

    //CONEXAO AO BANCO
    private DatabaseConnection db = new DatabaseConnection();

    //---CONTRATOS---

    //INSERIR 
    public int inserir(ImunizacaoModel i) throws SQLException {

        String sql = "INSERT INTO imunizacoes (id_paciente, id_dose, data_aplicacao, fabricante, lote, local_aplicacao, profissional_aplicador) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, i.getId_paciente());
            stmt.setInt(2, i.getId_dose());
            stmt.setDate(3, Date.valueOf(i.getData_aplicacao()));
            stmt.setString(4, i.getFabricante());
            stmt.setString(5, i.getLote());
            stmt.setString(6, i.getLocal_aplicacao());
            stmt.setString(7, i.getProfissional_aplicador());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }

        return 0;
    }

    //LISTAR TODAS
    public List<ImunizacaoModel> listar() throws SQLException {

        List<ImunizacaoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM imunizacoes";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                ImunizacaoModel i = new ImunizacaoModel(
                        rs.getInt("id_imunizacao"),
                        rs.getInt("id_paciente"),
                        rs.getInt("id_dose"),
                        rs.getDate("data_aplicacao").toLocalDate()
                );

                i.setFabricante(rs.getString("fabricante"));
                i.setLote(rs.getString("lote"));
                i.setLocal_aplicacao(rs.getString("local_aplicacao"));
                i.setProfissional_aplicador(rs.getString("profissional_aplicador"));

                lista.add(i);
            }
        }

        return lista;
    }

    //BUSCAR POR ID
    public ImunizacaoModel buscarPorId(int id) throws SQLException {

        String sql = "SELECT * FROM imunizacoes WHERE id_imunizacao=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                ImunizacaoModel i = new ImunizacaoModel(
                        rs.getInt("id_imunizacao"),
                        rs.getInt("id_paciente"),
                        rs.getInt("id_dose"),
                        rs.getDate("data_aplicacao").toLocalDate()
                );

                i.setFabricante(rs.getString("fabricante"));
                i.setLote(rs.getString("lote"));
                i.setLocal_aplicacao(rs.getString("local_aplicacao"));
                i.setProfissional_aplicador(rs.getString("profissional_aplicador"));

                return i;
            }
        }

        return null;
    }

    //ATUALIZAR
    public boolean atualizar(int id, ImunizacaoModel i) throws SQLException {

        String sql = "UPDATE imunizacoes SET id_paciente=?, id_dose=?, data_aplicacao=?, fabricante=?, lote=?, local_aplicacao=?, profissional_aplicador=? WHERE id_imunizacao=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, i.getId_paciente());
            stmt.setInt(2, i.getId_dose());
            stmt.setDate(3, Date.valueOf(i.getData_aplicacao()));
            stmt.setString(4, i.getFabricante());
            stmt.setString(5, i.getLote());
            stmt.setString(6, i.getLocal_aplicacao());
            stmt.setString(7, i.getProfissional_aplicador());
            stmt.setInt(8, id);

            return stmt.executeUpdate() > 0;
        }
    }

    //DELETAR
    public boolean deletar(int id) throws SQLException {

        String sql = "DELETE FROM imunizacoes WHERE id_imunizacao=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    //LISTAR POR PACIENTE
    public List<ImunizacaoModel> buscarPorPaciente(int idPaciente) throws SQLException {

        List<ImunizacaoModel> lista = new ArrayList<>();

        String sql = "SELECT * FROM imunizacoes WHERE id_paciente=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ImunizacaoModel i = new ImunizacaoModel(
                        rs.getInt("id_imunizacao"),
                        rs.getInt("id_paciente"),
                        rs.getInt("id_dose"),
                        rs.getDate("data_aplicacao").toLocalDate()
                );

                i.setFabricante(rs.getString("fabricante"));
                i.setLote(rs.getString("lote"));
                i.setLocal_aplicacao(rs.getString("local_aplicacao"));
                i.setProfissional_aplicador(rs.getString("profissional_aplicador"));

                lista.add(i);
            }
        }

        return lista;
    }

    //LISTAR POR PERIODO **
    public List<ImunizacaoModel> buscarPorPeriodo(int idPaciente, LocalDate inicio, LocalDate fim) throws SQLException {

        List<ImunizacaoModel> lista = new ArrayList<>();

        String sql = "SELECT * FROM imunizacoes WHERE id_paciente=? AND data_aplicacao BETWEEN ? AND ?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);
            stmt.setDate(2, Date.valueOf(inicio));
            stmt.setDate(3, Date.valueOf(fim));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ImunizacaoModel i = new ImunizacaoModel(
                        rs.getInt("id_imunizacao"),
                        rs.getInt("id_paciente"),
                        rs.getInt("id_dose"),
                        rs.getDate("data_aplicacao").toLocalDate()
                );
                lista.add(i);
            }
        }

        return lista;
    }

    // DELETAR TODAS IMUNIZACOES PACIENTE **
    public boolean deletarPorPaciente(int idPaciente) throws SQLException {

        String sql = "DELETE FROM imunizacoes WHERE id_paciente=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);
            return stmt.executeUpdate() > 0;
        }
    }

}