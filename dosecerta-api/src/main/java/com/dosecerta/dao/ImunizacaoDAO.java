package com.dosecerta.dao;

import com.dosecerta.model.ImunizacaoModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ImunizacaoDAO {

    private final JdbcTemplate jdbcTemplate;

    public ImunizacaoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Salvar imunização
    public void salvar(ImunizacaoModel imunizacao) {
        String sql = "INSERT INTO imunizacao (paciente_id, dose_id, data_aplicacao) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                imunizacao.getPacienteId(),
                imunizacao.getDoseId(),
                imunizacao.getDataAplicacao()
        );
    }

    // Alterar imunização
    public void atualizar(ImunizacaoModel imunizacao) {
        String sql = "UPDATE imunizacao SET paciente_id = ?, dose_id = ?, data_aplicacao = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                imunizacao.getPacienteId(),
                imunizacao.getDoseId(),
                imunizacao.getDataAplicacao(),
                imunizacao.getId()
        );
    }

    // Excluir imunização por id
    public void deletar(int id) {
        String sql = "DELETE FROM imunizacao WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Excluir todas imunizações de um paciente
    public void deletarPorPaciente(int pacienteId) {
        String sql = "DELETE FROM imunizacao WHERE paciente_id = ?";
        jdbcTemplate.update(sql, pacienteId);
    }

    // Consultar todas imunizações
    public List<ImunizacaoModel> listarTodas() {
        String sql = "SELECT * FROM imunizacao";
        return jdbcTemplate.query(sql, mapImunizacao());
    }

    // Consultar por id da imunização
    public ImunizacaoModel buscarPorId(int id) {
        String sql = "SELECT * FROM imunizacao WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, mapImunizacao(), id);
    }

    // Consultar por paciente
    public List<ImunizacaoModel> listarPorPaciente(int pacienteId) {
        String sql = "SELECT * FROM imunizacao WHERE paciente_id = ?";
        return jdbcTemplate.query(sql, mapImunizacao(), pacienteId);
    }

    // Consultar por paciente e intervalo de datas
    public List<ImunizacaoModel> listarPorPacienteEPeriodo(int pacienteId, LocalDate dtIni, LocalDate dtFim) {
        String sql = "SELECT * FROM imunizacao WHERE paciente_id = ? AND data_aplicacao BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, mapImunizacao(), pacienteId, dtIni, dtFim);
    }

    // RowMapper p mapear o resultado do SQL para ImunizacaoModel
    private RowMapper<ImunizacaoModel> mapImunizacao() {
        return (rs, rowNum) -> new ImunizacaoModel(
                rs.getInt("id"),
                rs.getInt("paciente_id"),
                rs.getInt("dose_id"),
                rs.getDate("data_aplicacao").toLocalDate()
        );
    }
}