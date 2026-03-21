package com.dosecerta.model;

public class VacinaModel {

    public enum PublicoAlvo {
        CRIANCA,
        ADOLESCENTE,
        ADULTO,
        GESTANTE
    }

    private Integer id_vacina;
    private String nome_vacina;
    private String descricao_vacina;
    private Integer limite_aplicacao;
    private PublicoAlvo publico_alvo;

    public VacinaModel() {
    }

    public VacinaModel(Integer id_vacina, String nome_vacina, String descricao_vacina, Integer limite_aplicacao,
            PublicoAlvo publico_alvo) {
        this.id_vacina = id_vacina;
        this.nome_vacina = nome_vacina;
        this.descricao_vacina = descricao_vacina;
        this.limite_aplicacao = limite_aplicacao;
        this.publico_alvo = publico_alvo;
    }

    public Integer getIdVacina() {
        return id_vacina;
    }

    public void setIdVacina(Integer id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getNomeVacina() {
        return nome_vacina;
    }

    public void setNomeVacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public String getDescricaoVacina() {
        return descricao_vacina;
    }

    public void setDescricaoVacina(String descricao_vacina) {
        this.descricao_vacina = descricao_vacina;
    }

    public Integer getLimiteAplicacao() {
        return limite_aplicacao;
    }

    public void setLimiteAplicacao(Integer limite_aplicacao) {
        this.limite_aplicacao = limite_aplicacao;
    }

    public PublicoAlvo getPublicoAlvo() {
        return publico_alvo;
    }

    public void setPublicoAlvo(PublicoAlvo publico_alvo) {
        this.publico_alvo = publico_alvo;
    }

    @Override
    public String toString() {
        return "Vacina{" +
                "id=" + id_vacina +
                ", nome='" + nome_vacina + '\'' +
                ", descricao='" + descricao_vacina + '\'' +
                ", limiteAplicacao=" + limite_aplicacao +
                ", publicoAlvo=" + publico_alvo +
                '}';
    }
}