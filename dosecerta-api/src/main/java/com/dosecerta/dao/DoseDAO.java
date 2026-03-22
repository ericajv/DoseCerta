package com.dosecerta.dao;

import com.dosecerta.model.DoseModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DoseDAO {

    private final JdbcTemplate jdbcTemplate;

    public DoseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(DoseModel dose) {
        String sql = "INSERT INTO dose (numero, vacina_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, dose.getNumero(), dose.getVacinaId());
    }
}