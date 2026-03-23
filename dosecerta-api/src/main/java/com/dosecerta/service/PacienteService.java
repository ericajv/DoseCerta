package com.dosecerta.service;

import java.sql.SQLException;
import java.util.List;

import com.dosecerta.dao.PacienteDAO;
import com.dosecerta.model.PacienteModel;

public class PacienteService {

    private PacienteDAO dao = new PacienteDAO();

    public int criar(PacienteModel p) throws SQLException {
        return dao.inserir(p);
    }

    public List<PacienteModel> listar() throws SQLException {
        return dao.listar();
    }

    public PacienteModel buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id).orElse(null);
    }

    public boolean atualizar(int id, PacienteModel p) throws SQLException {
        return dao.atualizar(id, p);
    }

    public boolean deletar(int id) throws SQLException {
        return dao.deletar(id);
    }
}