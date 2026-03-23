package com.dosecerta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dosecerta.config.DatabaseConnection;
import com.dosecerta.model.VacinaModel;

@Repository
public class VacinaDAO {

    //CONEXAO AO BANCO
    private DatabaseConnection db = new DatabaseConnection();

    //---CONTRATOS---
    //BUSCAR POR ID
    public VacinaModel buscarPorId(int id) throws SQLException {

        String sql = "SELECT * FROM vacina WHERE id_vacina = ?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Integer limite = rs.getObject("limite_aplicacao") != null
                        ? rs.getInt("limite_aplicacao")
                        : null;

                return new VacinaModel(
                        rs.getInt("id_vacina"),
                        rs.getString("nome_vacina"),
                        rs.getString("descricao_vacina"),
                        limite,
                        VacinaModel.PublicoAlvo.valueOf(rs.getString("publico_alvo"))
                );
            }
        }

        return null;
    }

    //LISTAR TODAS
    public List<VacinaModel> listar() throws SQLException {

        List<VacinaModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM vacina";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Integer limite = rs.getObject("limite_aplicacao") != null
                        ? rs.getInt("limite_aplicacao")
                        : null;

                VacinaModel v = new VacinaModel(
                        rs.getInt("id_vacina"),
                        rs.getString("nome_vacina"),
                        rs.getString("descricao_vacina"),
                        limite,
                        VacinaModel.PublicoAlvo.valueOf(rs.getString("publico_alvo"))
                );

                lista.add(v);
            }
        }

        return lista;
    }

    //CONSULTAR POR PUBLICO ALVO
    public List<VacinaModel> buscarPorPublicoAlvo(String publico) throws SQLException {

        List<VacinaModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM vacina WHERE publico_alvo = ?";

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, publico);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Integer limite = rs.getObject("limite_aplicacao") != null
                        ? rs.getInt("limite_aplicacao")
                        : null;

                VacinaModel v = new VacinaModel(
                        rs.getInt("id_vacina"),
                        rs.getString("nome_vacina"),
                        rs.getString("descricao_vacina"),
                        limite,
                        VacinaModel.PublicoAlvo.valueOf(rs.getString("publico_alvo"))
                );

                lista.add(v);
            }
        }

        return lista;
    }

    //CONSULTAR POR IDADE EM MESES
    public List<VacinaModel> buscarPorIdadeMaiorQue(int meses) throws SQLException {

        List<VacinaModel> lista = new ArrayList<>();

        String sql = """
            SELECT DISTINCT v.*
            FROM vacina v
            JOIN dose d ON v.id_vacina = d.id_vacina
            WHERE d.idade_recomendada_aplicacao > ?
        """;

        try (Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, meses);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Integer limite = rs.getObject("limite_aplicacao") != null
                        ? rs.getInt("limite_aplicacao")
                        : null;

                VacinaModel v = new VacinaModel(
                        rs.getInt("id_vacina"),
                        rs.getString("nome_vacina"),
                        rs.getString("descricao_vacina"),
                        limite,
                        VacinaModel.PublicoAlvo.valueOf(rs.getString("publico_alvo"))
                );

                lista.add(v);
            }
        }

        return lista;
    }

}