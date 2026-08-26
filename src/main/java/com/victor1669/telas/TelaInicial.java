package com.victor1669.telas;

import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.SessionManager;
import com.victor1669.utils.Tela;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public final class TelaInicial extends javax.swing.JPanel {

    public TelaInicial() {
        initComponents();
        configureLinks();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                mountComponents();
            }

        });

    }

    void mountComponents() {
        boasVindas.setHorizontalAlignment(SwingConstants.CENTER);
        boasVindas.setText("Seja bem-vindo(a), " + SessionManager.getNomeLogado());
    }

    void configureLinks() {
        Map<JButton, Tela> conexoes = Map.of(
                emprestimoLink, Tela.EMPRESTIMO,
                devolucaoLink, Tela.DEVOLUCAO,
                funcionariosLink, Tela.FUNCIONARIO,
                livrosLink, Tela.LIVROS,
                pagamentoLink, Tela.PAGAMENTO,
                usuariosLink, Tela.CONSULTA
        );

        ScreenManager.vincularBotoes(conexoes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        pagamentoLink = new javax.swing.JButton();
        usuariosLink = new javax.swing.JButton();
        emprestimoLink = new javax.swing.JButton();
        resetDatabase = new javax.swing.JButton();
        devolucaoLink = new javax.swing.JButton();
        funcionariosLink = new javax.swing.JButton();
        livrosLink = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        boasVindas = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(954, 526));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Livraria ETEC");

        pagamentoLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pagamentoLink.setText("Pagamento");

        usuariosLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usuariosLink.setText("Usuários");

        emprestimoLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emprestimoLink.setText("Empréstimo de livros");

        resetDatabase.setBackground(new java.awt.Color(255, 102, 102));
        resetDatabase.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetDatabase.setForeground(new java.awt.Color(0, 0, 0));
        resetDatabase.setText("Resetar Banco de dados");
        resetDatabase.addActionListener(this::resetDatabaseActionPerformed);

        devolucaoLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        devolucaoLink.setText("Devolução de livros");

        funcionariosLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        funcionariosLink.setText("Funcionários");

        livrosLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        livrosLink.setText("Livros");

        sairButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sairButton.setText("Sair");
        sairButton.addActionListener(this::sairButtonActionPerformed);

        boasVindas.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        boasVindas.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(titulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emprestimoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(devolucaoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(resetDatabase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(funcionariosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(livrosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pagamentoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usuariosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(sairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sairButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emprestimoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(devolucaoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pagamentoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usuariosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(funcionariosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(livrosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(resetDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resetDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetDatabaseActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Certeza de que quer reiniciar o banco de dados?");
        if (response == JOptionPane.YES_OPTION) {
            ConexaoJPA.getInstancia().resetarBanco(() -> {
                JOptionPane.showMessageDialog(null, "Banco reiniciado com sucesso!");
                System.exit(0);
            });
        }
    }//GEN-LAST:event_resetDatabaseActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        SessionManager.logout();
        ScreenManager.navegarPara(Tela.ENTRAR_SISTEMA);
    }//GEN-LAST:event_sairButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boasVindas;
    private javax.swing.JButton devolucaoLink;
    private javax.swing.JButton emprestimoLink;
    private javax.swing.JButton funcionariosLink;
    private javax.swing.JButton livrosLink;
    private javax.swing.JButton pagamentoLink;
    private javax.swing.JButton resetDatabase;
    private javax.swing.JButton sairButton;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton usuariosLink;
    // End of variables declaration//GEN-END:variables
}
