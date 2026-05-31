package com.victor1669.ui;

import java.awt.Dimension;

/**
 *
 * @author Victor1669
 */
public enum Tela {
    INICIAL("TELA_INICIAL", new Dimension(430, 580)),
    EMPRESTIMO("EMPRESTIMO", new Dimension(954, 532)),
    FUNCIONARIO("FUNCIONARIO", new Dimension(772, 562)),
    LIVROS("LIVROS", new Dimension(772, 562)),
    PAGAMENTO("PAGAMENTO", new Dimension(683, 539)),
    CONSULTA("CONSULTA", new Dimension(551, 607)),
    USUARIOS("USUARIOS", new Dimension(551, 607));

    private final String nome;
    private final Dimension tamanho;

    Tela(String nome, Dimension tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public Dimension getTamanho() {
        return tamanho;
    }
}
