package com.dosecerta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dosecerta.service.EstatisticaService;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {
    
    private EstatisticaService service = new EstatisticaService();

    //QTE DE VACINAS APLICADAS EM PACIENTE, POR ID PACIENTE
    @GetMapping("/imunizacoes/paciente/{id_paciente}")
    public int porPaciente(@PathVariable int id_paciente) throws Exception {
        return service.totalPorPaciente(id_paciente);
    }

    //QTE DE VACINAS APLICAVEIS NO PROXIMO MES PARA UM PACIENTE, POR ID PACIENTE
    @GetMapping("/proximas_imunizacoes/paciente/{id}")
    public int proximasPaciente(@PathVariable("id") int id_paciente) throws Exception {
        return service.proximasPaciente(id_paciente);
    }

    //QTE DE VACINAS ATRASADAS DE UM PACIENTE
    @GetMapping("/imunizacoes_atrasadas/paciente/{id}")
    public int vacinasAtrasadas(@PathVariable("id") int id_paciente) throws Exception {
    return service.vacinasAtrasadas(id_paciente);
}
    
    //QTE DE VACINAS RECOMENDADAS ACIMA DE UMA DETERMINADA IDADE
    @GetMapping("/imunizacoes/idade_maior/{meses}")
    public int vacinasAcima(@PathVariable int meses) throws Exception {
    return service.vacinasAcimaDeIdade(meses);
}

}
