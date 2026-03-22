package com.dosecerta.model;

public class DoseModel {

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
    }
}