package com.dosecerta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dosecerta.service.EstatisticaService;

// controller rest para estatísticas de vacinação - rotas em /estatistica
@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {

    private EstatisticaService service = new EstatisticaService();

    // get /estatistica/total/{idPaciente} - total de vacinas aplicadas ao paciente
    @GetMapping("/imunizacoes/paciente/{idPaciente}")
    public ResponseEntity<Integer> totalPorPaciente(@PathVariable int idPaciente) throws Exception {
        int total = service.totalPorPaciente(idPaciente);
        return ResponseEntity.ok(total); // 200 - retorna contagem
    }

    // get /estatistica/proximas/{idPaciente} - vacinas aplicáveis no próximo mês
    @GetMapping("/proximas_imunizacoes/paciente/{idPaciente}")
    public ResponseEntity<Integer> proximasPaciente(@PathVariable int idPaciente) throws Exception {
        int total = service.proximasPaciente(idPaciente);
        return ResponseEntity.ok(total); // 200 - retorna contagem
    }

    // get /estatistica/atrasadas/{idPaciente} - vacinas atrasadas para o paciente
    @GetMapping("/imunizacoes_atrasadas/paciente/{idPaciente}")
    public ResponseEntity<Integer> vacinasAtrasadas(@PathVariable int idPaciente) throws Exception {
        int total = service.vacinasAtrasadas(idPaciente);
        return ResponseEntity.ok(total); // 200 - retorna contagem
    }

    // get /estatistica/acima/{meses} - vacinas recomendadas acima de uma idade (em meses)
    @GetMapping("/imunizacoes/idade_maior/{meses}")
    public ResponseEntity<Integer> vacinasAcimaDeIdade(@PathVariable int meses) throws Exception {
        int total = service.vacinasAcimaDeIdade(meses);
        return ResponseEntity.ok(total); // 200 - retorna contagem
    }
}
