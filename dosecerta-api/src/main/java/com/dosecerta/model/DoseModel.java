package com.dosecerta.model;

public class DoseModel {

    //DECLARAR
    private Integer id_dose;
    private Integer id_vacina;
    private String descricao_dose;
    private Integer idade_recomendada_aplicacao;


    //CONSTRUTOR DA DOSE
    public DoseModel () {}

    public DoseModel(Integer id_dose, Integer id_vacina, String descricao_dose, Integer idade_recomendada_aplicacao) {
        this.id_dose = id_dose;
        this.id_vacina = id_vacina;
        this.descricao_dose = descricao_dose;
        this.idade_recomendada_aplicacao = idade_recomendada_aplicacao;
    }

    //GETTERS E SETTERS DA DOSE
    public Integer getId_dose() {
        return id_dose;
    }

    public void setId_dose(Integer id_dose) {
        this.id_dose = id_dose;
    }

    public Integer getId_vacina() {
        return id_vacina;
    }

    public void setId_vacina(Integer id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getDescricao_dose() {
        return descricao_dose;
    }

    public void setDescricao_dose(String descricao_dose) {
        this.descricao_dose = descricao_dose;
    }

    public Integer getIdade_recomendada_aplicacao() {
        return idade_recomendada_aplicacao;
    }

    public void setIdade_recomendada_aplicacao(Integer idade_recomendada_aplicacao) {
        this.idade_recomendada_aplicacao = idade_recomendada_aplicacao;
    }

}
