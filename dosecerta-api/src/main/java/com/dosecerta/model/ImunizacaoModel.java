package com.dosecerta.model;

import java.time.LocalDate;

public class ImunizacaoModel {

    private Integer id_imunizacao;
    private Integer id_paciente;
    private Integer id_dose;
    private LocalDate data_aplicacao;
    private String fabricante;
    private String lote;
    private String local_aplicacao;
    private String profissional_aplicador;

    public ImunizacaoModel() {
    }

    public ImunizacaoModel(Integer id_imunizacao, Integer id_paciente, Integer id_dose, LocalDate data_aplicacao,
            String fabricante, String lote, String local_aplicacao, String profissional_aplicador) {
        this.id_imunizacao = id_imunizacao;
        this.id_paciente = id_paciente;
        this.id_dose = id_dose;
        this.data_aplicacao = data_aplicacao;
        this.fabricante = fabricante;
        this.lote = lote;
        this.local_aplicacao = local_aplicacao;
        this.profissional_aplicador = profissional_aplicador;
    }

    public Integer getIdImunizacao() {
        return id_imunizacao;
    }

    public void setIdImunizacao(Integer id_imunizacao) {
        this.id_imunizacao = id_imunizacao;
    }

    public Integer getPaciente() {
        return id_paciente;
    }

    public void setPaciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getDose() {
        return id_dose;
    }

    public void setDose(Integer id_dose) {
        this.id_dose = id_dose;
    }

    public LocalDate getDataAplicacao() {
        return data_aplicacao;
    }

    public void setDataAplicacao(LocalDate data_aplicacao) {
        this.data_aplicacao = data_aplicacao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getLocalAplicacao() {
        return local_aplicacao;
    }

    public void setLocalAplicacao(String local_aplicacao) {
        this.local_aplicacao = local_aplicacao;
    }

    public String getProfissionalAplicador() {
        return profissional_aplicador;
    }

    public void setProfissionalAplicador(String profissional_aplicador) {
        this.profissional_aplicador = profissional_aplicador;
    }

    @Override
    public String toString() {
        return "Imunizacao{" +
                "id=" + id_imunizacao +
                ", paciente=" + id_paciente +
                ", dose=" + id_dose +
                ", dataAplicacao=" + data_aplicacao +
                ", fabricante='" + fabricante + '\'' +
                ", lote='" + lote + '\'' +
                ", localAplicacao='" + local_aplicacao + '\'' +
                ", profissionalAplicador='" + profissional_aplicador + '\'' +
                '}';
    }
}