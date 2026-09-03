package com.victor1669.telas;

import com.victor1669.services.results.LoginResult;
import com.victor1669.services.UsuarioService;
import com.victor1669.services.results.ValidationResult;

import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.Tela;
import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class TelaEntrarSistema extends javax.swing.JPanel {

    public TelaEntrarSistema() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        campoSenha = new java.awt.TextField();
        entrarButton = new javax.swing.JButton();
        cadastroButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Senha");

        entrarButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        entrarButton.setText("Entrar");
        entrarButton.addActionListener(this::login);

        cadastroButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadastroButton.setText("Cadastrar");
        cadastroButton.addActionListener(this::cadastroButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(entrarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastroButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(313, 313, 313))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrarButton)
                    .addComponent(cadastroButton))
                .addContainerGap(217, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    void handleLogin() {
        UsuarioService service = new UsuarioService();
        String nome = campoNome.getText();
        String senha = campoSenha.getText();

        try {
            LoginResult resultado = service.login(nome, senha);

            switch (resultado) {
                case SUCCESS -> {
                    ScreenManager.navegarPara(Tela.INICIAL);
                }
                case INVALID_FIELDS ->
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
                case WRONG_PASSWORD ->
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                case USER_NOT_FOUND ->
                    JOptionPane.showMessageDialog(null, "Usuário não existente!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar login: " + e.getMessage());
        }

        clearForm();
    }

    private void cadastroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroButtonActionPerformed
        UsuarioService service = new UsuarioService();
        String nome = campoNome.getText();
        String senha = campoSenha.getText();

        try {
            ValidationResult resultado = service.cadastrar(nome, senha);

            if (resultado == ValidationResult.INVALID_FIELDS) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
                return;
            }

            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");

            handleLogin();

        } catch (HeadlessException e) {
            Throwable cause = e.getCause();
            if (cause != null && cause.getMessage() != null
                    && cause.getMessage().toLowerCase().contains("duplicate")) {
                JOptionPane.showMessageDialog(null, "Este nome está em uso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage());
            }
        }

        clearForm();
    }//GEN-LAST:event_cadastroButtonActionPerformed

    private void login(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login
        handleLogin();
    }//GEN-LAST:event_login

    private void clearForm() {
        campoNome.setText("");
        campoSenha.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastroButton;
    private java.awt.TextField campoNome;
    private java.awt.TextField campoSenha;
    private javax.swing.JButton entrarButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
