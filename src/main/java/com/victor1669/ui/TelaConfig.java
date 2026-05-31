package com.victor1669.ui;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Victor1669
 */
public class TelaConfig {

    private final String nome;
    private final Dimension tamanho;
    private final JButton botaoLink;

    public TelaConfig(String nome, Dimension tamanho, JButton botaoLink) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.botaoLink = botaoLink;
    }

    public String getNome() {
        return nome;
    }

    public Dimension getTamanho() {
        return tamanho;
    }

    public JButton getBotaoLink() {
        return botaoLink;
    }
}
