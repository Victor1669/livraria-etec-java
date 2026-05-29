package com.victor1669.classes;

import com.victor1669.interfaces.IPagamento;

public abstract class Funcionario implements IPagamento {

    protected String nome;
    protected double salario;
    protected double bonus;
    protected String tipoFuncionario;


    public abstract double calcularBonus();

    // ==================== GETTERS E SETTERS ====================
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

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
