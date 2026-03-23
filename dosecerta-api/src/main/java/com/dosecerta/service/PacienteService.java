package com.dosecerta.service;

import java.sql.SQLException;
import java.util.List;

import com.dosecerta.dao.PacienteDAO;
import com.dosecerta.model.PacienteModel;

public class PacienteService {

    private final PacienteDAO dao = new PacienteDAO();

    // CADASTRAR PACIENTE
    public int cadastrar(PacienteModel p) throws SQLException {
        return dao.inserir(p);
    }

    // LISTAR PACIENTES
    public List<PacienteModel> listar() throws SQLException {
        return dao.listar();
    }

    // BUSCAR POR ID
    public PacienteModel buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    // BUSCAR POR CPF
    public PacienteModel buscarPorCpf(String cpf) throws SQLException {
        return dao.buscarPorCpf(cpf);
    }

    // ATUALIZAR PACIENTE
    public boolean atualizar(int id, PacienteModel p) throws SQLException {
        return dao.atualizar(id, p);
    }

    // DELETAR PACIENTE
    public boolean deletar(int id) throws SQLException {
        return dao.deletar(id);
    }
}
