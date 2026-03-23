package com.dosecerta.model;

import java.time.LocalDate;

public class PacienteModel {

    public enum Sexo {
        M, F
    }

    private Integer id_paciente;
    private String nome_paciente;
    private String cpf_paciente;
    private Sexo sexo;
    private LocalDate data_nascimento;

    public PacienteModel() {
    }

    public PacienteModel(Integer id_paciente, String nome_paciente, Sexo sexo, LocalDate data_nascimento) {
        this.id_paciente = id_paciente;
        this.nome_paciente = nome_paciente;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    public PacienteModel(Integer id_paciente, String nome_paciente, String cpf_paciente, Sexo sexo, LocalDate data_nascimento) {
        this.id_paciente = id_paciente;
        this.nome_paciente = nome_paciente;
        this.cpf_paciente = cpf_paciente;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
    }

    public Integer getIdPaciente() {
        return id_paciente;
    }

    public void setIdPaciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNomePaciente() {
        return nome_paciente;
    }

    public void setNomePaciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public String getCpfPaciente() {
        return cpf_paciente;
    }

    public void setCpfPaciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id_paciente +
                ", nome='" + nome_paciente + '\'' +
                ", cpf='" + cpf_paciente + '\'' +
                ", sexo=" + sexo +
                ", dataNascimento=" + data_nascimento+
                '}';
    }
}