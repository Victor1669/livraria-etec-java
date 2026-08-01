package com.victor1669.telas;

import com.victor1669.models.FuncionarioModel;
import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.FuncionarioDAO;
import com.victor1669.daos.PagamentoDAO;
import com.victor1669.services.FuncionarioService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.victor1669.ui.ScreenManager;
import com.victor1669.ui.Tela;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor1669
 */
public final class TelaFuncionarios extends javax.swing.JPanel {

    List<FuncionarioModel> lista;

    public TelaFuncionarios() {
        initComponents();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                atualizarTabela();
            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNome = new java.awt.TextField();
        campoSalario = new java.awt.TextField();
        selectTipoFuncionario = new javax.swing.JComboBox<>();
        pagamentoButton = new javax.swing.JButton();
        cadastroButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        scrollTabelaFuncionarios = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(954, 526));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Funcionário");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Salario");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cargo");

        selectTipoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Bibliotecario", "Gerente" }));

        pagamentoButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pagamentoButton.setForeground(new java.awt.Color(255, 0, 0));
        pagamentoButton.setText("Pagamento");
        pagamentoButton.addActionListener(this::pagamentoButtonActionPerformed);

        cadastroButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadastroButton.setText("Cadastrar");
        cadastroButton.addActionListener(this::cadastroButtonActionPerformed);

        cancelarButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(this::cancelarButtonActionPerformed);

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncionarios.setShowGrid(false);
        scrollTabelaFuncionarios.setViewportView(tabelaFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoSalario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectTipoFuncionario, 0, 761, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(pagamentoButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelarButton)
                            .addGap(29, 29, 29)
                            .addComponent(cadastroButton))
                        .addComponent(scrollTabelaFuncionarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(campoSalario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTipoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagamentoButton)
                    .addComponent(cancelarButton)
                    .addComponent(cadastroButton))
                .addGap(18, 18, 18)
                .addComponent(scrollTabelaFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        ScreenManager.navegarPara(Tela.INICIAL);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void cadastroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroButtonActionPerformed
        FuncionarioService service = new FuncionarioService();
        FuncionarioModel f = service.criarFuncionario(
                campoNome.getText(),
                campoSalario.getText(),
                selectTipoFuncionario.getSelectedItem().toString()
        );

        if (f == null) {
            JOptionPane.showMessageDialog(null, "Os campos devem ser preenchidos corretamente!");
            return;
        }

        try {
            Connection conn = ConexaoMySQL.getInstancia().getConexao();

            var fdao = new FuncionarioDAO(conn);

            fdao.inserir(f);

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

            campoNome.setText("");
            campoSalario.setText("");
            selectTipoFuncionario.setSelectedIndex(0);

            campoNome.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + e.getMessage());
            return;
        }

        atualizarTabela();
    }//GEN-LAST:event_cadastroButtonActionPerformed

    public void atualizarTabela() {
        try {
            Connection conn = ConexaoMySQL.getInstancia().getConexao();
            FuncionarioDAO fdao = new FuncionarioDAO(conn);

            lista = fdao.selecionarTodos();

            String[] colunas = {"Nome", "Cargo"};
            DefaultTableModel model = new DefaultTableModel(colunas, 0);

            for (FuncionarioModel f : lista) {
                Object[] linha = {f.getNome(), f.getTipoFuncionario()};
                model.addRow(linha);
            }

            tabelaFuncionarios.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados: " + e.getMessage());
        }
    }

    private void pagamentoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoButtonActionPerformed
        int linhaSelecionada = tabelaFuncionarios.getSelectedRow();

        FuncionarioModel f = lista.get(linhaSelecionada);

        try {
            Connection conn = ConexaoMySQL.getInstancia().getConexao();

            PagamentoDAO pdao = new PagamentoDAO(conn);

            pdao.pagar(f);

            JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pagar funcionário " + f.getNome() + ": " + e.getMessage());
        }
    }//GEN-LAST:event_pagamentoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastroButton;
    private java.awt.TextField campoNome;
    private java.awt.TextField campoSalario;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton pagamentoButton;
    private javax.swing.JScrollPane scrollTabelaFuncionarios;
    private javax.swing.JComboBox<String> selectTipoFuncionario;
    private javax.swing.JTable tabelaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
