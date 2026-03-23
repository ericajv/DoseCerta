package com.dosecerta.controller;

<<<<<<< HEAD
import com.dosecerta.dao.ImunizacaoDAO;
import com.dosecerta.model.ImunizacaoModel;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

=======
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

// controller rest para imunizações - rotas em /imunizacao
>>>>>>> develop
@RestController
@RequestMapping("/imunizacao")
public class ImunizacaoController {

<<<<<<< HEAD
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
=======
    private ImunizacaoService service = new ImunizacaoService();

    // get /imunizacao/consultar - lista todas as imunizações
    @GetMapping("/consultar")
    public ResponseEntity<List<ImunizacaoModel>> listar() throws SQLException {
        List<ImunizacaoModel> imunizacoes = service.listar();

        if (imunizacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(imunizacoes);
    }

    // get /imunizacao/consultar/{id} - busca uma imunização pelo id
    @GetMapping("/consultar/{id}")
    public ResponseEntity<ImunizacaoModel> buscarPorId(@PathVariable int id) throws SQLException {
        ImunizacaoModel imunizacao = service.buscarPorId(id);

        if (imunizacao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(imunizacao);
    }

    // get /imunizacao/consultar/paciente/{id} - lista imunizações de um paciente
    @GetMapping("/consultar/paciente/{id}")
    public ResponseEntity<List<ImunizacaoModel>> porPaciente(@PathVariable int id) throws SQLException {
        List<ImunizacaoModel> imunizacoes = service.porPaciente(id);

        if (imunizacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(imunizacoes);
    }

    // get /imunizacao/consultar/paciente/{id}/periodo/{dtIni}/{dtFim} - filtra por
    // período
    @GetMapping("/consultar/paciente/{id}/aplicacao/{dtIni}/{dtFim}")
    public ResponseEntity<List<ImunizacaoModel>> porPeriodo(
            @PathVariable int id,
            @PathVariable String dtIni,
            @PathVariable String dtFim) throws SQLException {

        LocalDate inicio = LocalDate.parse(dtIni);
        LocalDate fim = LocalDate.parse(dtFim);
        List<ImunizacaoModel> imunizacoes = service.porPeriodo(id, inicio, fim);

        if (imunizacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(imunizacoes);
    }

    // post /imunizacao/inserir - registra uma nova imunização
    @PostMapping("/inserir")
    public ResponseEntity<String> registrar(@RequestBody ImunizacaoModel imunizacao) throws SQLException {
        int idGerado = service.registrar(imunizacao);

        if (idGerado <= 0) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar imunização."); // 400
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Imunização cadastrada! ID: " + idGerado); // 201
    }

    // put /imunizacao/alterar/{id} - atualiza uma imunização existente
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody ImunizacaoModel imunizacao)
            throws SQLException {
        boolean atualizado = service.atualizar(id, imunizacao);

        if (!atualizado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Imunização atualizada com sucesso!");
    }

    // delete /imunizacao/excluir/{id} - remove uma imunização pelo id
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) throws SQLException {
        boolean removido = service.deletar(id);

        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    // delete /imunizacao/excluir/paciente/{id} - remove todas imunizações de um
    // paciente
    @DeleteMapping("/excluir/paciente/{id}")
    public ResponseEntity<Void> deletarPorPaciente(@PathVariable int id) throws SQLException {
        boolean removido = service.deletarPorPaciente(id);

        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
>>>>>>> develop
