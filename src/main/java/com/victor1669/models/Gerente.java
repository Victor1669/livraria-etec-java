package com.victor1669.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("gerente")
public class Gerente extends FuncionarioModel {

    public Gerente() {
    }

    public Gerente(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public double processarPagamento() {
        double bonus = salario * 0.3;
        System.out.println(getNome() + ", voce recebeu um bonus de: " + bonus);
        return getSalario() + bonus;
    }
}
