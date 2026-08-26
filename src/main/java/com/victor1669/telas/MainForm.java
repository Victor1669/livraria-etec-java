package com.victor1669.telas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import com.victor1669.conexoes.*;
import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.SessionManager;
import com.victor1669.utils.Tela;
import jakarta.persistence.PersistenceException;
import javax.swing.JOptionPane;

public class MainForm extends javax.swing.JFrame {

    private static CardLayout cardLayout;
    private static JPanel container;

    public MainForm() {
        initComponents();
        mountComponents();
    }

    final void mountComponents() {
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        container.add(new TelaInicial(), Tela.INICIAL.getNome());
        container.add(new TelaFuncionarios(), Tela.FUNCIONARIO.getNome());
        container.add(new TelaPagamento(), Tela.PAGAMENTO.getNome());
        container.add(new TelaLivros(), Tela.LIVROS.getNome());
        container.add(new TelaEmprestimos(), Tela.EMPRESTIMO.getNome());
        container.add(new TelaDevolucao(), Tela.DEVOLUCAO.getNome());
        container.add(new TelaUsuarios(), Tela.CONSULTA.getNome());
        container.add(new TelaEntrarSistema(), Tela.ENTRAR_SISTEMA.getNome());

        getContentPane().setLayout(new BorderLayout());
        add(container, BorderLayout.CENTER);

        ScreenManager.inicializar(this, container, cardLayout);

        String token = SessionManager.getToken();
        /* TESTES DO TOKEN
        System.out.println("Token: " + token);
        System.out.println("Sessão válida? " + (SessionManager.verificarSessao() ? "sim" : "não"));
        System.out.println("Sem token? : " + (token.length() <= 0 ? "sim" : "não"));
        System.out.println("Tamanho do token: " + token.length());
         */

        // ===== CONTROLE DE SESSÃO =====
        if (SessionManager.verificarSessao()) {
            System.out.println("Acessando sistema...");

            ScreenManager.navegarPara(Tela.INICIAL);

        } else {

            if (token.isEmpty()) {
                System.out.println("Sem token...");
            } else {

                System.out.println("Sessão inválida...");

                ScreenManager.navegarPara(Tela.ENTRAR_SISTEMA);

                JOptionPane.showMessageDialog(null,
                        "Sua sessão expirou. Faça login novamente.",
                        "Sessão Expirada",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            ScreenManager.navegarPara(Tela.ENTRAR_SISTEMA);
        }

    }

    static final void connectJPA() {
        try {
            ConexaoJPA.getInstancia();
            System.out.println("Conectou com sucesso!");
        } catch (PersistenceException ex) {
            System.out.println("Erro ao conectar no banco: " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        connectJPA();
        java.awt.EventQueue.invokeLater(() -> {
            MainForm form = new MainForm();
            form.setVisible(true);
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConexaoJPA.getInstancia().encerrar();
        }));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Livraria ETEC");
        setPreferredSize(new java.awt.Dimension(954, 532));
        setResizable(false);
        setSize(new java.awt.Dimension(954, 532));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
