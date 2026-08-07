package com.victor1669.telas;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.Tela;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public final class TelaInicial extends javax.swing.JPanel {

    public TelaInicial() {
        initComponents();
        configureLinks();


    }

    void configureLinks() {
        Map<JButton, Tela> conexoes = Map.of(
                emprestimoLink, Tela.EMPRESTIMO,
                funcionarioLink, Tela.FUNCIONARIO,
                livroLink, Tela.LIVROS,
                pagamentoLink, Tela.PAGAMENTO,
                usuariosLink, Tela.CONSULTA
        );

        ScreenManager.vincularBotoes(conexoes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pagamentoLink = new javax.swing.JButton();
        funcionarioLink = new javax.swing.JButton();
        usuariosLink = new javax.swing.JButton();
        livroLink = new javax.swing.JButton();
        emprestimoLink = new javax.swing.JButton();
        resetDatabase = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Biblioteca");

        pagamentoLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pagamentoLink.setText("Pagamento");

        funcionarioLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        funcionarioLink.setText("Funcionários");

        usuariosLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usuariosLink.setText("Usuários");

        livroLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        livroLink.setText("Livro");

        emprestimoLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emprestimoLink.setText("Empréstimo de livros");

        resetDatabase.setBackground(new java.awt.Color(255, 102, 102));
        resetDatabase.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetDatabase.setForeground(new java.awt.Color(0, 0, 0));
        resetDatabase.setText("Resetar Banco de dados");
        resetDatabase.addActionListener(this::resetDatabaseActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(livroLink, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(usuariosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(funcionarioLink, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pagamentoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(resetDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emprestimoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel1)))
                .addGap(312, 312, 312))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(emprestimoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagamentoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funcionarioLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livroLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(resetDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resetDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetDatabaseActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Certeza de que quer reiniciar o banco de dados?");

        if (response == JOptionPane.YES_OPTION) {
            ConexaoMySQL.getInstancia().resetarBanco(() -> {
                JOptionPane.showMessageDialog(null, "Banco reiniciado com sucesso!");
                System.exit(0);
            });
        }
    }//GEN-LAST:event_resetDatabaseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton emprestimoLink;
    private javax.swing.JButton funcionarioLink;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton livroLink;
    private javax.swing.JButton pagamentoLink;
    private javax.swing.JButton resetDatabase;
    private javax.swing.JButton usuariosLink;
    // End of variables declaration//GEN-END:variables
}
