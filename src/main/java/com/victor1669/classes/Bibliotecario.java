package com.victor1669.classes;

public class Bibliotecario extends Funcionario {

    public Bibliotecario(String nome, double salario, double bonus) {
        this.nome = nome;
        this.salario = salario;
        this.bonus = bonus;
        this.tipoFuncionario = "bibliotecario";
    }

    public Bibliotecario() {
    }
    
    

    @Override
    public double calcularBonus() {
        bonus = getSalario() / 20;

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
