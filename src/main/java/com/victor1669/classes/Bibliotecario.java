package com.victor1669.classes;

import com.victor1669.models.Funcionario;

public class Bibliotecario extends Funcionario {

    public Bibliotecario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.tipoFuncionario = "bibliotecario";
    }

    public Bibliotecario() {
    }

    @Override
    public double processarPagamento() {
        bonus = calcularBonus();

        System.out.println(getNome() + ", voce recebeu um bonus de: " + bonus);

        double valorFinal = getSalario() + bonus;

        return valorFinal;
    }

}
