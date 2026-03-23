package com.dosecerta.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dosecerta.model.ImunizacaoModel;
import com.dosecerta.service.ImunizacaoService;

@RestController
@RequestMapping("imunizacao")
public class ImunizacaoController {
    
    private ImunizacaoService service = new ImunizacaoService();

    //ADICIONAR IMUNIZACAO
    @PostMapping("/inserir")
    public int registrar(@RequestBody ImunizacaoModel i) throws SQLException {
        return service.registrar(i);
    }

    //ATUALIZAR IMUNIZACAO POR ID DA IMUNIZACAO
    @PutMapping("/alterar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody ImunizacaoModel i) throws SQLException {
        return service.atualizar(id, i);
    }

    //EXCLUIR IMUNIZACAO POR ID DA IMUNIZACAO
    @DeleteMapping("/excluir/{id_imunizacao}")
    public boolean deletar(@PathVariable("id_imunizacao") int id) throws SQLException {
        return service.deletar(id);
    }

    //EXCLUIR TODAS AS IMUNIZACOES DE UM DETERMINADO PACIENTE
    @DeleteMapping("/excluir/paciente/{id_paciente}")
    public boolean deletarPorPaciente(@PathVariable int id_paciente) throws SQLException {
        return service.deletarPorPaciente(id_paciente);
    }

    //CONSULTAR TODAS AS IMUNIZACOES
    @GetMapping("/consultar")
    public List<ImunizacaoModel> listar() throws SQLException {
        return service.listar();
    }

    //CONSULTAR IMUNIZACAO POR ID DA IMUNIZACAO
    @GetMapping("/consultar/{id}")
    public ImunizacaoModel buscarPorId(@PathVariable int id) throws SQLException {
        return service.buscarPorId(id);
    }

    //CONSULTAR IMUNIZACAO POR ID DO PACIENTE
    @GetMapping("/consultar/paciente/{id}")
    public List<ImunizacaoModel> porPaciente(@PathVariable int id) throws SQLException {
        return service.porPaciente(id);
    }

    //CONSULTAR IMUNIZACOES por id do paciente e intervalo de aplicação
    @GetMapping("/consultar/paciente/{id}/aplicacao/{dt_ini}/{dt_fim}")
    public List<ImunizacaoModel> porPeriodo(
            @PathVariable int id,
            @PathVariable String dt_ini,
            @PathVariable String dt_fim
    ) throws SQLException {

        return service.porPeriodo(
                id,
                LocalDate.parse(dt_ini),
                LocalDate.parse(dt_fim)
        );
    }


}
