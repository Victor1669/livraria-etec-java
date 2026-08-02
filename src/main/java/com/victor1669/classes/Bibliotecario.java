package com.victor1669.classes;

import com.victor1669.models.FuncionarioModel;

public class Bibliotecario extends FuncionarioModel {

    public Bibliotecario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.tipoFuncionario = "bibliotecario";
    }

    public Bibliotecario() {
    }

    @Override
    public double processarPagamento() {
        double bonus = salario * 0.1;

        System.out.println(getNome() + ", voce recebeu um bonus de: " + bonus);

        double valorFinal = getSalario() + bonus;

        return valorFinal;
    }

}
