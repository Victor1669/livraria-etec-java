package com.victor1669.utils;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ScreenManager {

    private static JFrame instancia;
    private static Container container;
    private static CardLayout cardLayout;
    public static Tela telaAtual;

    public static void inicializar(JFrame frame, Container cont, CardLayout layout) {
        instancia = frame;
        container = cont;
        cardLayout = layout;
    }

    public static void navegarPara(Tela tela) {
        instancia.setTitle(tela.getNome().equals("TELA_INICIAL") ? "Livraria ETEC" : tela.getNome());
        cardLayout.show(container, tela.getNome());

        telaAtual = tela;

        instancia.setLocationRelativeTo(null);
        instancia.revalidate();
        instancia.repaint();
    }

    public static void vincularBotoes(Map<JButton, Tela> mapeamento) {
        mapeamento.forEach((botao, tela) -> {
            botao.addActionListener(e -> navegarPara(tela));
        });
    }
}
