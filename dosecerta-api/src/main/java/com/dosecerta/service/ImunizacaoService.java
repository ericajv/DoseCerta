package com.dosecerta.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dosecerta.dao.ImunizacaoDAO;
import com.dosecerta.model.ImunizacaoModel;

public class ImunizacaoService {
    private ImunizacaoDAO dao = new ImunizacaoDAO();

    //INSERIR IMUNIZACAO
    public int registrar(ImunizacaoModel i) throws SQLException {
        return dao.inserir(i);
    }

    //LISTAR IMUNIZACOES
    public List<ImunizacaoModel> listar() throws SQLException {
        return dao.listar();
    }

    //BUSCAR POR ID IMUNIZACAO
    public ImunizacaoModel buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    //BUSCAR POR ID PACIENTE
    public List<ImunizacaoModel> porPaciente(int id) throws SQLException {
        return dao.buscarPorPaciente(id);
    }

    //BUSCAR POR PERIODO
    public List<ImunizacaoModel> porPeriodo(int id, LocalDate ini, LocalDate fim) throws SQLException {
        return dao.buscarPorPeriodo(id, ini, fim);
    }

    //ATUALIZAR IMUNIZACAO
    public boolean atualizar(int id, ImunizacaoModel i) throws SQLException {
        return dao.atualizar(id, i);
    }

    //DELETAR IMUNIZACAO
    public boolean deletar(int id) throws SQLException {
        return dao.deletar(id);
    }

    //DELETAR POR PACIENTE
    public boolean deletarPorPaciente(int idPaciente) throws SQLException {
        return dao.deletarPorPaciente(idPaciente);
    }

}
