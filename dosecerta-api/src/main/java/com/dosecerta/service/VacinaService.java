package com.dosecerta.service;

import java.sql.SQLException;
import java.util.List;

import com.dosecerta.dao.VacinaDAO;
import com.dosecerta.model.VacinaModel;

public class VacinaService {

    private VacinaDAO dao = new VacinaDAO();

    //LISTAR TODAS
    public List<VacinaModel> listar() throws SQLException {
        return dao.listar();
    }

    //BUSCAR POR PUBLICO ALVO (FAIXA ETARIA)
    public List<VacinaModel> porPublico(String publico) throws SQLException {
        return dao.buscarPorPublicoAlvo(publico);
    }

    //BUSCAR POR IDADE
    public List<VacinaModel> porIdade(int meses) throws SQLException {
        return dao.buscarPorIdadeMaiorQue(meses);
    }

}