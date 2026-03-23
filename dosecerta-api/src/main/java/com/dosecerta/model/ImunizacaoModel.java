package com.dosecerta.model;

import java.time.LocalDate;

public class ImunizacaoModel {

    //DECLARAR
    private Integer id_imunizacao;
    private Integer id_paciente;
    private Integer id_dose;
    private LocalDate data_aplicacao;
    private String fabricante;
    private String lote;
    private String local_aplicacao;
    private String profissional_aplicador;
    

    //CONSTRUTOR DA IMUNIZACAO
    public ImunizacaoModel () {}

    public ImunizacaoModel(Integer id_imunizacao, Integer id_paciente, Integer id_dose, LocalDate data_aplicacao) {
    this.id_imunizacao = id_imunizacao;
    this.id_paciente = id_paciente;
    this.id_dose = id_dose;
    this.data_aplicacao = data_aplicacao;
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

    public ImunizacaoModel(Integer id_paciente, Integer id_dose, LocalDate data_aplicacao,
            String fabricante, String lote, String local_aplicacao, String profissional_aplicador) {
        this.id_paciente = id_paciente;
        this.id_dose = id_dose;
        this.data_aplicacao = data_aplicacao;
        this.fabricante = fabricante;
        this.lote = lote;
        this.local_aplicacao = local_aplicacao;
        this.profissional_aplicador = profissional_aplicador;
    }

    //GETTERS E SETTERS DA IMUNIZACAO
    public Integer getId_imunizacao() {
        return id_imunizacao;
    }

    public void setId_imunizacao(Integer id_imunizacao) {
        this.id_imunizacao = id_imunizacao;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getId_dose() {
        return id_dose;
    }

    public void setId_dose(Integer id_dose) {
        this.id_dose = id_dose;
    }

    public LocalDate getData_aplicacao() {
        return data_aplicacao;
    }

    public void setData_aplicacao(LocalDate data_aplicacao) {
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

    public String getLocal_aplicacao() {
        return local_aplicacao;
    }

    public void setLocal_aplicacao(String local_aplicacao) {
        this.local_aplicacao = local_aplicacao;
    }

    public String getProfissional_aplicador() {
        return profissional_aplicador;
    }

    public void setProfissional_aplicador(String profissional_aplicador) {
        this.profissional_aplicador = profissional_aplicador;
    }
    
}
