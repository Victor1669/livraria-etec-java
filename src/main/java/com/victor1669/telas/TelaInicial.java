package com.victor1669.telas;

import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.dtos.UsuarioDTO;
import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.SessionManager;
import com.victor1669.utils.Tela;

import java.util.Map;
import java.time.LocalDate;

import java.awt.*;
import java.awt.event.HierarchyEvent;
import javax.swing.*;

public final class TelaInicial extends javax.swing.JPanel {

    UsuarioDTO User;

    public TelaInicial() {
        initComponents();

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0 && isShowing()) {
                atualizarTela();
            }
        });
    }

    void atualizarTela() {
        SessionManager.buscarDadosUser();
        User = SessionManager.User;

        if (User == null) {
            return;
        }

        removeAll();

        mountNorthLayout();
        mountCenterComponents();
        mountSouthComponents();

        revalidate();
        repaint();
    }

    void mountNorthLayout() {
        JPanel northPanel = new JPanel(new GridLayout(2, 1));
        northPanel.setOpaque(false);

        JLabel titulo = new JLabel();
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Liberation Sans", 0, 30));
        titulo.setText("Livraria ETEC");

        JLabel boasVindas = new JLabel();
        boasVindas.setHorizontalAlignment(SwingConstants.CENTER);
        boasVindas.setText("Seja bem-vindo(a) " + User.getNome() + "!");

        northPanel.add(titulo, BorderLayout.NORTH);
        northPanel.add(boasVindas, BorderLayout.SOUTH);

        add(northPanel, BorderLayout.NORTH);

    }

    void mountCenterComponents() {
        JPanel botoesPanel = new JPanel(new GridLayout(0, 3, 20, 20));
        botoesPanel.setOpaque(false);

        if (User.getRole().equals("user")) {
            JButton emprestimo = new JButton("Empréstimo de livros");
            JButton devolucao = new JButton("Devolução de livros");
            JButton[] botoes = {emprestimo, devolucao};
            Map<JButton, Tela> telasUsuario = Map.of(
                    devolucao, Tela.DEVOLUCAO,
                    emprestimo, Tela.EMPRESTIMO
            );
            for (JButton botao : botoes) {
                botao.setPreferredSize(new Dimension(200, 100));
                botoesPanel.add(botao);
            }
            ScreenManager.vincularBotoes(telasUsuario);
        } else {
            JButton funcionarios = new JButton("Funcionários");
            JButton pagamento = new JButton("Pagamentos");
            JButton livros = new JButton("Livros");
            JButton usuarios = new JButton("Usuários");
            JButton[] botoes = {funcionarios, pagamento, livros, usuarios};
            Map<JButton, Tela> telasAdmin = Map.of(
                    funcionarios, Tela.FUNCIONARIO,
                    usuarios, Tela.CONSULTA,
                    pagamento, Tela.PAGAMENTO,
                    livros, Tela.LIVROS
            );
            for (JButton botao : botoes) {
                botao.setPreferredSize(new Dimension(200, 100));
                botoesPanel.add(botao);
            }
            ScreenManager.vincularBotoes(telasAdmin);
        }

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setOpaque(false);
        wrapper.add(botoesPanel);
        add(wrapper, BorderLayout.CENTER);
    }

    void mountSouthComponents() {

        JPanel southPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        southPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        southPanel.setOpaque(false);

        JLabel texto = new JLabel();
        texto.setText("Feito por Victor1669");

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> {
            SessionManager.logout();
            ScreenManager.navegarPara(Tela.ENTRAR_SISTEMA);
        });

        southPanel.add(texto, BorderLayout.EAST);

        if (User.getRole().equals("admin")) {
            JButton resetDatabaseButton = new JButton("Resetar Banco de Dados");
            resetDatabaseButton.setBackground(new Color(255, 102, 102));
            resetDatabaseButton.addActionListener(e -> {
                int response = JOptionPane.showConfirmDialog(null, "Certeza de que quer reiniciar o banco de dados?");
                if (response == JOptionPane.YES_OPTION) {
                    ConexaoJPA.getInstancia().resetarBanco(() -> {
                        JOptionPane.showMessageDialog(null, "Banco reiniciado com sucesso!");
                        System.exit(0);
                    });
                }
            });
            southPanel.add(resetDatabaseButton, BorderLayout.CENTER);
        } else {
            JLabel texto2 = new JLabel();
            texto2.setText(LocalDate.now().toString());
            texto2.setHorizontalAlignment(SwingConstants.CENTER);
            southPanel.add(texto2, BorderLayout.CENTER);
        }

        southPanel.add(sairButton, BorderLayout.WEST);

        add(southPanel, BorderLayout.SOUTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(954, 526));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
