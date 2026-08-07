package com.victor1669.telas;

import com.victor1669.models.LivroModel;
import com.victor1669.services.LivroService;
import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.Tela;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.List;

import java.sql.SQLException;

public final class TelaLivros extends javax.swing.JPanel {

    public TelaLivros() {
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
        cadastroButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        campoAutor = new java.awt.TextField();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Livros");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        cadastroButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadastroButton.setText("Cadastrar");
        cadastroButton.addActionListener(this::cadastroButtonActionPerformed);

        cancelarButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(this::cancelarButtonActionPerformed);

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLivros.setCellSelectionEnabled(true);
        tabelaLivros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaLivros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaLivros.setShowGrid(false);
        jScrollPane1.setViewportView(tabelaLivros);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Autor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 840, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelarButton)
                                .addGap(18, 18, 18)
                                .addComponent(cadastroButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                                    .addComponent(campoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(cadastroButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        ScreenManager.navegarPara(Tela.INICIAL);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void cadastroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroButtonActionPerformed
        LivroService service = new LivroService();

        service.onInvalid = () -> {
            JOptionPane.showMessageDialog(null, "Os campos devem ser preenchidos corretamente!");
        };

        service.onSuccess = () -> {
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");

            campoNome.setText("");
            campoAutor.setText("");

            campoNome.requestFocus();
        };

        try {
            LivroModel lm = new LivroModel();
            lm.setNome(campoNome.getText());
            lm.setAutor(campoAutor.getText());

            service.criar(lm);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro: " + e.getMessage());
        }

        atualizarTabela();
    }//GEN-LAST:event_cadastroButtonActionPerformed

    public void atualizarTabela() {
        LivroService service = new LivroService();

        try {
            List<LivroModel> lista = service.getItems();

            String[] colunas = {"Nome", "Autor"};
            var model = new DefaultTableModel(colunas, 0);

            for (LivroModel lm : lista) {
                Object[] linha = {lm.getNome(), lm.getAutor()};
                model.addRow(linha);
            }

            tabelaLivros.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados: " + e.getMessage());

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastroButton;
    private java.awt.TextField campoAutor;
    private java.awt.TextField campoNome;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLivros;
    // End of variables declaration//GEN-END:variables
}
