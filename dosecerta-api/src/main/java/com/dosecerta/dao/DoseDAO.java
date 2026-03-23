package com.dosecerta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dosecerta.config.DatabaseConnection;
import com.dosecerta.model.DoseModel;

@Repository
public class DoseDAO {

    //CONEXAO AO BANCO
    private DatabaseConnection db = new DatabaseConnection();

    //---CONTRATOS---

    //INSERIR 
    public int inserir(DoseModel d) throws SQLException {

        String sql = "INSERT INTO dose (id_vacina, descricao_dose, idade_recomendada_aplicacao) VALUES (?, ?, ?)";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, d.getId_vacina());
            stmt.setString(2, d.getDescricao_dose());
            stmt.setInt(3, d.getIdade_recomendada_aplicacao());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }

        return 0;
    }

    //LISTAR
    public List<DoseModel> listar() throws SQLException {

        List<DoseModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM dose";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                DoseModel d = new DoseModel(
                        rs.getInt("id_dose"),
                        rs.getInt("id_vacina"),
                        rs.getString("descricao_dose"),
                        rs.getInt("idade_recomendada_aplicacao")
                );

                lista.add(d);
            }
        }

        return lista;
    }

    //BUSCAR POR ID
    public DoseModel buscarPorId(int id) throws SQLException {

        String sql = "SELECT * FROM dose WHERE id_dose=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new DoseModel(
                        rs.getInt("id_dose"),
                        rs.getInt("id_vacina"),
                        rs.getString("descricao_dose"),
                        rs.getInt("idade_recomendada_aplicacao")
                );
            }
        }

        return null;
    }

    //ATUALIZAR
    public boolean atualizar(int id, DoseModel d) throws SQLException {

        String sql = "UPDATE dose SET id_vacina=?, descricao_dose=?, idade_recomendada_aplicacao=? WHERE id_dose=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, d.getId_vacina());
            stmt.setString(2, d.getDescricao_dose());
            stmt.setInt(3, d.getIdade_recomendada_aplicacao());
            stmt.setInt(4, id);

            return stmt.executeUpdate() > 0;
        }
    }

    //DELETAR
    public boolean deletar(int id) throws SQLException {

        String sql = "DELETE FROM dose WHERE id_dose=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    //LISTAR POR VACINA
    public List<DoseModel> buscarPorVacina(int idVacina) throws SQLException {

        List<DoseModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM dose WHERE id_vacina=?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVacina);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DoseModel d = new DoseModel(
                        rs.getInt("id_dose"),
                        rs.getInt("id_vacina"),
                        rs.getString("descricao_dose"),
                        rs.getInt("idade_recomendada_aplicacao")
                );
                lista.add(d);
            }
        }

        return lista;
    }

}