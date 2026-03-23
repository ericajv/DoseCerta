package com.dosecerta.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dosecerta.model.PacienteModel;
import com.dosecerta.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    
    private PacienteService service = new PacienteService();

    //ADICIONAR PACIENTE
    @PostMapping
    public int criar(@RequestBody PacienteModel p) throws SQLException {
        return service.criar(p);
    }

    //CONSULTAR TODOS OS PACIENTES
    @GetMapping("/consultar")
    public List<PacienteModel> listar() throws SQLException {
        return service.listar();
    }

    //CONSULTAR PACIENTE POR ID
    @GetMapping("/consultar/{id}")
    public PacienteModel buscar(@PathVariable int id) throws SQLException {
        return service.buscarPorId(id);
    }

    //ALTERAR PACIENTE
    @PutMapping("/alterar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody PacienteModel p) throws SQLException {
        return service.atualizar(id, p);
    }

    //EXCLUIR PACIENTE
    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) throws SQLException {
        return service.deletar(id);
    }

    
}
