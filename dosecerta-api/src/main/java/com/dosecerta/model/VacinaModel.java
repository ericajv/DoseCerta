package com.dosecerta.model;

public class VacinaModel {
    
    //DECLARAR
    public enum PublicoAlvo{
        CRIANÇA,
        ADOLESCENTE,
        ADULTO,
        GESTANTE
    }
    private Integer id_vacina;
    private String nome_vacina;
    private String descricao_vacina;
    private Integer limite_aplicacao;
    private PublicoAlvo publico_alvo;
    //private String publico_alvo;

    //METODO CONSTRUTOR DE VACINA
    public VacinaModel(){}

    public VacinaModel(Integer id_vacina, String nome_vacina, String descricao_vacina, Integer limite_aplicacao,
            PublicoAlvo publico_alvo) {
        this.id_vacina = id_vacina;
        this.nome_vacina = nome_vacina;
        this.descricao_vacina = descricao_vacina;
        this.limite_aplicacao = limite_aplicacao;
        this.publico_alvo = publico_alvo;
    }

    //GETTERS AND SETTERS DE VACINA

    public Integer getId_vacina() {
        return id_vacina;
    }

    public void setId_vacina(Integer id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getNome_vacina() {
        return nome_vacina;
    }

    public void setNome_vacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public String getDescricao_vacina() {
        return descricao_vacina;
    }

    public void setDescricao_vacina(String descricao_vacina) {
        this.descricao_vacina = descricao_vacina;
    }

    public Integer getLimite_aplicacao() {
        return limite_aplicacao;
    }

    public void setLimite_aplicacao(Integer limite_aplicacao) {
        this.limite_aplicacao = limite_aplicacao;
    }

    public PublicoAlvo getPublico_alvo() {
        return publico_alvo;
    }

    public void setPublico_alvo(PublicoAlvo publico_alvo) {
        this.publico_alvo = publico_alvo;
    }


}