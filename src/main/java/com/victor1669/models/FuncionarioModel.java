package com.victor1669.models;

import com.victor1669.interfaces.IPagamento;

public abstract class FuncionarioModel implements IPagamento {

    protected int id;
    protected String nome;
    protected double salario;
    protected String tipoFuncionario;

    @Override
    public String toString() {
        return "["
                + "id=\"" + id
                + "\", nome=\"" + nome
                + "\", salario=\"" + salario
                + "\", tipoFuncionario=\"" + tipoFuncionario
                + "\"]";
    }

    // ==================== GETTERS E SETTERS ====================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
