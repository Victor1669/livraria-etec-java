package com.victor1669.classes;

import com.victor1669.models.FuncionarioModel;

public class Gerente extends FuncionarioModel {

    public Gerente(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.tipoFuncionario = "gerente";
    }

    public Gerente() {
    }

    @Override
    public double processarPagamento() {
        double bonus = salario * 0.3;

        System.out.println(getNome() + ", voce recebeu um bonus de: " + bonus);

        double valorFinal = getSalario() + bonus;

        return valorFinal;
    }

}
