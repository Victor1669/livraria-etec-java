package com.victor1669.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bibliotecario")
public class Bibliotecario extends FuncionarioModel {

    public Bibliotecario() {
    }

    public Bibliotecario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public double processarPagamento() {
        double bonus = salario * 0.1;
        System.out.println(getNome() + ", voce recebeu um bonus de: " + bonus);
        return getSalario() + bonus;
    }
}
