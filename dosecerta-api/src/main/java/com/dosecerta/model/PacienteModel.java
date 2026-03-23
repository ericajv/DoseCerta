package com.dosecerta.model;

import java.time.LocalDate;

public class PacienteModel {

    //DECLARAR
    public enum Sexo {
        M, 
        F;
    }
    private Integer id_paciente;
    private String nome_paciente;
    private String cpf_paciente;
    //private String sexo;
    private Sexo sexo;
    private LocalDate data_nascimento;
    

    //CONSTRUTOR DO PACIENTE
    public PacienteModel() {}

    public PacienteModel(Integer id_paciente, String nome_paciente, Sexo sexo, LocalDate data_nascimento) {
        this.id_paciente = id_paciente;
        this.nome_paciente = nome_paciente;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    public PacienteModel(Integer id_paciente, String nome_paciente, String cpf_paciente, Sexo sexo,
            LocalDate data_nascimento) {
        this.id_paciente = id_paciente;
        this.nome_paciente = nome_paciente;
        this.cpf_paciente = cpf_paciente;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    //GETTERS E SETTERS DO PACIENTE
    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public String getCpf_paciente() {
        return cpf_paciente;
    }

    public void setCpf_paciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
}