package com.victor1669.classes;

public class Gerente extends Funcionario {
    public Gerente(String nome, double salario, double bonus) {
        this.nome = nome;
        this.salario = salario;
        this.bonus = bonus;
        this.tipoFuncionario = "gerente";
    }

    public Gerente() {
    }
    
    
    
    @Override
    public double calcularBonus() {
        bonus = getSalario() / 10;

        return bonus;
    }

    @Override
    public double processarPagamento() {
        bonus = calcularBonus();

        System.out.println(getNome() + ", você recebeu um bônus de: " + bonus);

        double valorFinal = getSalario() + bonus;

        return valorFinal;
    }

}
