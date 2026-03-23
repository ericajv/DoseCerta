package com.dosecerta.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dosecerta.model.VacinaModel;
import com.dosecerta.service.VacinaService;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {
    
    private VacinaService service = new VacinaService();

    //CONSULTAR TODAS AS VACINAS
    @GetMapping("/consultar")
    public List<VacinaModel> listar() throws SQLException {
        return service.listar();
    }

    //BUSCAR VACINA POR PUBLICO ALVO (FAIXA ETARIA)
    @GetMapping("/consultar/faixa_etaria/{p}")
    public List<VacinaModel> porPublico(@PathVariable String p) throws SQLException {
        return service.porPublico(p);
    }

    //CONSULTAR TODAS AS VACINAS RECOMENDADAS ACIMA DE UMA IDADE
    @GetMapping("/consultar/idade_maior/{meses}")
    public List<VacinaModel> porIdade(@PathVariable int meses) throws SQLException {
        return service.porIdade(meses);
    }

}
