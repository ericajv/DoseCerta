package com.dosecerta.controller;

import com.dosecerta.dao.ImunizacaoDAO;
import com.dosecerta.model.ImunizacaoModel;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/imunizacao")
public class ImunizacaoController {

    private final ImunizacaoDAO imunizacaoDAO;

    public ImunizacaoController(ImunizacaoDAO imunizacaoDAO) {
        this.imunizacaoDAO = imunizacaoDAO;
    }

    // Inserir imunização
    @PostMapping("/inserir")
    public String salvarImunizacao(@RequestBody ImunizacaoModel imunizacao) {
        imunizacaoDAO.salvar(imunizacao);
        return "Imunização salva com sucesso!";
    }

    // Alterar imunização
    @PutMapping("/alterar/{id}")
    public String atualizarImunizacao(@PathVariable int id, @RequestBody ImunizacaoModel imunizacao) {
        imunizacao.setId(id);
        imunizacaoDAO.atualizar(imunizacao);
        return "Imunização atualizada com sucesso!";
    }

    // Excluir imunização por id
    @DeleteMapping("/excluir/{id}")
    public String deletarImunizacao(@PathVariable int id) {
        imunizacaoDAO.deletar(id);
        return "Imunização deletada com sucesso!";
    }

    // Excluir todas imunizações de um paciente
    @DeleteMapping("/excluir/paciente/{pacienteId}")
    public String deletarImunizacoesPorPaciente(@PathVariable int pacienteId) {
        imunizacaoDAO.deletarPorPaciente(pacienteId);
        return "Todas imunizações do paciente deletadas!";
    }

    // Listar todas imunizações
    @GetMapping("/consultar")
    public List<ImunizacaoModel> listarTodas() {
        return imunizacaoDAO.listarTodas();
    }

    // Consultar por id da imunização
    @GetMapping("/consultar/{id}")
    public ImunizacaoModel buscarPorId(@PathVariable int id) {
        return imunizacaoDAO.buscarPorId(id);
    }

    // Consultar por paciente
    @GetMapping("/consultar/paciente/{pacienteId}")
    public List<ImunizacaoModel> listarPorPaciente(@PathVariable int pacienteId) {
        return imunizacaoDAO.listarPorPaciente(pacienteId);
    }

    // Consultar por paciente e intervalo de datas
    @GetMapping("/consultar/paciente/{pacienteId}/aplicacao/{dtIni}/{dtFim}")
    public List<ImunizacaoModel> listarPorPacienteEPeriodo(
            @PathVariable int pacienteId,
            @PathVariable String dtIni,
            @PathVariable String dtFim
    ) {
        LocalDate dataInicio = LocalDate.parse(dtIni);
        LocalDate dataFim = LocalDate.parse(dtFim);
        return imunizacaoDAO.listarPorPacienteEPeriodo(pacienteId, dataInicio, dataFim);
    }

// Endpoint de teste pelo navegador
@GetMapping("/teste")
public String teste() {

    ImunizacaoModel imunizacao = new ImunizacaoModel();

    imunizacao.setPacienteId(1);
    imunizacao.setDoseId(1);
    imunizacao.setDataAplicacao(LocalDate.now());

    imunizacaoDAO.salvar(imunizacao);

    return "Imunização inserida com sucesso!";
}

}