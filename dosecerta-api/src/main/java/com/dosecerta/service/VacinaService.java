package com.dosecerta.service;

import java.sql.SQLException;
import java.util.List;

import com.dosecerta.dao.VacinaDAO;
import com.dosecerta.model.VacinaModel;
import com.dosecerta.model.VacinaModel.PublicoAlvo;

public class VacinaService {

    private final VacinaDAO dao = new VacinaDAO();

    // CADASTRAR VACINA
    public int cadastrar(VacinaModel v) throws SQLException {
        return dao.inserir(v);
    }

    // LISTAR VACINAS
    public List<VacinaModel> listar() throws SQLException {
        return dao.listar();
    }

    // BUSCAR POR ID
    public VacinaModel buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    // BUSCAR POR PUBLICO ALVO
    public List<VacinaModel> buscarPorPublicoAlvo(PublicoAlvo publicoAlvo) throws SQLException {
        return dao.buscarPorPublicoAlvo(publicoAlvo);
    }

    // BUSCAR VACINAS COM DOSE RECOMENDADA ACIMA DE X MESES
    public List<VacinaModel> buscarPorIdadeMaior(int meses) throws SQLException {
        return dao.buscarPorIdadeMaior(meses);
    }

    // ATUALIZAR VACINA
    public boolean atualizar(int id, VacinaModel v) throws SQLException {
        return dao.atualizar(id, v);
    }

    // DELETAR VACINA
    public boolean deletar(int id) throws SQLException {
        return dao.deletar(id);
    }
}
