package com.dosecerta.model;

import java.time.LocalDate;

public class ImunizacaoModel {

    private Integer id;
    private Integer pacienteId;
    private Integer doseId;
    private LocalDate dataAplicacao;

    // Construtor vazio
    public ImunizacaoModel() {
    }

    // Construtor com todos os parâmetros
    public ImunizacaoModel(Integer id, Integer pacienteId, Integer doseId, LocalDate dataAplicacao) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.doseId = doseId;
        this.dataAplicacao = dataAplicacao;
    }

    // Getters
    public Integer getId() { return id; }
    public Integer getPacienteId() { return pacienteId; }
    public Integer getDoseId() { return doseId; }
    public LocalDate getDataAplicacao() { return dataAplicacao; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setPacienteId(Integer pacienteId) { this.pacienteId = pacienteId; }
    public void setDoseId(Integer doseId) { this.doseId = doseId; }
    public void setDataAplicacao(LocalDate dataAplicacao) { this.dataAplicacao = dataAplicacao; }
}