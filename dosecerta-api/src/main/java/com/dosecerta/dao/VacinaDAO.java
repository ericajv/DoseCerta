package com.dosecerta.dao;

import com.dosecerta.model.VacinaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VacinaDAO {

    @Autowired
    private DataSource dataSource;

    public void salvar(VacinaModel vacina) {
        String sql = "INSERT INTO vacina (nome_vacina, descricao_vacina, limite_aplicacao, publico_alvo) VALUES (?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vacina.getNomeVacina());

            if (vacina.getDescricaoVacina() != null) {
                stmt.setString(2, vacina.getDescricaoVacina());
            } else {
                stmt.setNull(2, Types.VARCHAR);
            }

            if (vacina.getLimiteAplicacao() != null) {
                stmt.setInt(3, vacina.getLimiteAplicacao());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            if (vacina.getPublicoAlvo() != null) {
                stmt.setString(4, vacina.getPublicoAlvo().name());
            } else {
                stmt.setNull(4, Types.VARCHAR);
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar vacina", e);
        }
    }

    public void atualizar(int id, VacinaModel vacina) {
        String sql = "UPDATE vacina SET nome_vacina=?, descricao_vacina=?, limite_aplicacao=?, publico_alvo=? WHERE id_vacina=?";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vacina.getNomeVacina());

            if (vacina.getDescricaoVacina() != null) {
                stmt.setString(2, vacina.getDescricaoVacina());
            } else {
                stmt.setNull(2, Types.VARCHAR);
            }

            if (vacina.getLimiteAplicacao() != null) {
                stmt.setInt(3, vacina.getLimiteAplicacao());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            if (vacina.getPublicoAlvo() != null) {
                stmt.setString(4, vacina.getPublicoAlvo().name());
            } else {
                stmt.setNull(4, Types.VARCHAR);
            }

            stmt.setInt(5, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar vacina", e);
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM vacina WHERE id_vacina=?";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar vacina", e);
        }
    }

    public Optional<VacinaModel> buscarPorId(int id) {
        String sql = "SELECT * FROM vacina WHERE id_vacina=?";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(mapearVacina(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar vacina por ID", e);
        }

        return Optional.empty();
    }

    public List<VacinaModel> listarTodos() {
        String sql = "SELECT * FROM vacina";
        List<VacinaModel> lista = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearVacina(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vacinas", e);
        }

        return lista;
    }

    public boolean existePorId(int id) {
        String sql = "SELECT 1 FROM vacina WHERE id_vacina=?";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar existência da vacina", e);
        }
    }

    private VacinaModel mapearVacina(ResultSet rs) throws SQLException {
        VacinaModel v = new VacinaModel();

        v.setIdVacina(rs.getInt("id_vacina"));
        v.setNomeVacina(rs.getString("nome_vacina"));
        v.setDescricaoVacina(rs.getString("descricao_vacina"));

        int limite = rs.getInt("limite_aplicacao");
        if (!rs.wasNull()) {
            v.setLimiteAplicacao(limite);
        }

        String publicoStr = rs.getString("publico_alvo");
        if (publicoStr != null) {
            v.setPublicoAlvo(VacinaModel.PublicoAlvo.valueOf(publicoStr));
        }

        return v;
    }
}