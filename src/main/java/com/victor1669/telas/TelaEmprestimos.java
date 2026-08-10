package com.victor1669.telas;

import com.victor1669.models.EmprestimoModel;
import com.victor1669.models.LivroModel;

import com.victor1669.services.EmprestimoService;
import com.victor1669.services.LivroService;
import com.victor1669.services.ValidationResult;

import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.Tela;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class TelaEmprestimos extends javax.swing.JPanel {

    List<LivroModel> lista;

    public TelaEmprestimos() {
        initComponents();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                atualizarTabela();
            }
        });
    }

    public void atualizarTabela() {
        LivroService service = new LivroService();

        try {
            lista = service.getAll();

            String[] colunas = {"Livro", "Autor"};
            DefaultTableModel model = new DefaultTableModel(colunas, 0);

            for (LivroModel lm : lista) {
                Object[] linha = {lm.getNome(), lm.getAutor()};
                model.addRow(linha);
            }

            tabelaLivros.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados: " + e.getMessage());

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        emprestimoButton = new javax.swing.JButton();
        scrollTabelaLivros = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));

        cancelarButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(this::cancelarButtonActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Empréstimo de livros");

        emprestimoButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emprestimoButton.setText("Realizar empréstimo");
        emprestimoButton.addActionListener(this::emprestimoButtonActionPerformed);

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Autor"
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
        tabelaLivros.setShowGrid(false);
        scrollTabelaLivros.setViewportView(tabelaLivros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(scrollTabelaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emprestimoButton)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTabelaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(emprestimoButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        ScreenManager.navegarPara(Tela.INICIAL);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void emprestimoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprestimoButtonActionPerformed
        EmprestimoService emprestimoService = new EmprestimoService();

        try {
            int linhaSelecionada = tabelaLivros.getSelectedRow();
            LivroModel lm = lista.get(linhaSelecionada);
            EmprestimoModel em = new EmprestimoModel();

            em.setId_livro(lm.getId());
            em.setId_usuario(1);
            ValidationResult resultado = emprestimoService.create(em);
            if (resultado == ValidationResult.INVALID_FIELDS) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar o empréstimo: dados inválidos.");
                return;
            }
            JOptionPane.showMessageDialog(null, "Livro " + lm.getNome() + " emprestado para " + "User" + "!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar empréstimo de livro: " + e);
        }
    }//GEN-LAST:event_emprestimoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton emprestimoButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane scrollTabelaLivros;
    private javax.swing.JTable tabelaLivros;
    // End of variables declaration//GEN-END:variables
}
