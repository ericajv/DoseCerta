package com.dosecerta.controller;

import com.dosecerta.dao.DoseDAO;
import com.dosecerta.model.DoseModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    private final DoseDAO doseDAO;

    public DoseController(DoseDAO doseDAO) {
        this.doseDAO = doseDAO;
    }

    // Endpoint principal p salvar via POST
    @PostMapping
    public String salvarDose(@RequestBody DoseModel dose) {
        doseDAO.salvar(dose);
        return "Dose salva com sucesso!";
    }

    // teste pelo navegador
    @GetMapping("/teste")
    public String teste() {

        DoseModel dose = new DoseModel();
        dose.setNumero(1);
        dose.setVacinaId(1); 

        doseDAO.salvar(dose);

        return "Dose inserida via GET";
    }
}