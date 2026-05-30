package com.victor1669.classes;

public class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.tipoFuncionario = "gerente";
    }

    public Gerente() {
    }

    @Override
    public double processarPagamento() {
        bonus = calcularBonus();

        System.out.println(getNome() + ", voce recebeu um bonus de: " + bonus);

        double valorFinal = getSalario() + bonus;

        return valorFinal;
    }

}
