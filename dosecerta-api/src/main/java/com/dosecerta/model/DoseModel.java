package com.dosecerta.model;

public class DoseModel {

<<<<<<< HEAD
    private Integer id;        // corresponde ao id_dose do banco
    private int numero;        // número da dose
    private Integer vacinaId;  // corresponde ao vacina_id do banco

    // Construtor vazio
    public DoseModel() {
    }

    // Construtor com parâmetros
    public DoseModel(Integer id, int numero, Integer vacinaId) {
        this.id = id;
        this.numero = numero;
        this.vacinaId = vacinaId;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public Integer getVacinaId() {
        return vacinaId;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setVacinaId(Integer vacinaId) {
        this.vacinaId = vacinaId;
=======
    private Integer id_dose;
    private Integer id_vacina;
    private String descricao_dose;
    private Integer idade_recomenda_aplicacao;

    public DoseModel() {
    }

    public DoseModel(Integer id_dose, Integer id_vacina, String descricao_dose, Integer idade_recomenda_aplicacao) {
        this.id_dose = id_dose;
        this.id_vacina = id_vacina;
        this.descricao_dose = descricao_dose;
        this.idade_recomenda_aplicacao = idade_recomenda_aplicacao;
    }

    public Integer getIdDose() {
        return id_dose;
    }

    public void setIdDose(Integer id_dose) {
        this.id_dose = id_dose;
    }

    public Integer getVacina() {
        return id_vacina;
    }

    public void setVacina(Integer id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getDescricaoDose() {
        return descricao_dose;
    }

    public void setDescricaoDose(String descricao_dose) {
        this.descricao_dose = descricao_dose;
    }

    public Integer getIdadeRecomendadaAplicacao() {
        return idade_recomenda_aplicacao;
    }

    public void setIdadeRecomendadaAplicacao(Integer idade_recomenda_aplicacao) {
        this.idade_recomenda_aplicacao = idade_recomenda_aplicacao;
    }

    @Override
    public String toString() {
        return "Dose{" +
                "id=" + id_dose +
                ", vacina=" + id_vacina +
                ", descricao='" + descricao_dose + '\'' +
                ", idadeRecomendada=" + idade_recomenda_aplicacao +
                '}';
>>>>>>> develop
    }
}