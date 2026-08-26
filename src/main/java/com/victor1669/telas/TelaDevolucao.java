package com.victor1669.telas;

import com.victor1669.dtos.EmprestimoFormatado;
import com.victor1669.services.EmprestimoService;
import com.victor1669.utils.LocalStorage;
import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.SessionManager;
import com.victor1669.utils.Tela;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaDevolucao extends javax.swing.JPanel {

    List<EmprestimoFormatado> lista;

    public TelaDevolucao() {
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
        EmprestimoService service = new EmprestimoService();

        try {
            lista = service.getAllEmprestimos(SessionManager.getNomeLogado());

            String[] colunas = {"Usuario", "Livro", "Data"};
            DefaultTableModel model = new DefaultTableModel(colunas, 0);

            for (EmprestimoFormatado em : lista) {
                Object[] linha = {
                    em.getNomeUsuario(),
                    em.getNomeLivro(),
                    em.getDataEmprestimo()
                };
                model.addRow(linha);
            }

            tabelaEmprestimos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        scrollTabelaEmprestimos = new javax.swing.JScrollPane();
        tabelaEmprestimos = new javax.swing.JTable();
        cancelarButton = new javax.swing.JButton();
        devolucaoButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Empréstimo de livros");

        tabelaEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Livro", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEmprestimos.setShowGrid(false);
        scrollTabelaEmprestimos.setViewportView(tabelaEmprestimos);

        cancelarButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(this::cancelarButtonActionPerformed);

        devolucaoButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        devolucaoButton.setText("Devolver Livro");
        devolucaoButton.addActionListener(this::devolucaoButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(677, Short.MAX_VALUE)
                .addComponent(cancelarButton)
                .addGap(18, 18, 18)
                .addComponent(devolucaoButton)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(scrollTabelaEmprestimos)
                    .addGap(32, 32, 32)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 408, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devolucaoButton)
                    .addComponent(cancelarButton))
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(scrollTabelaEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void devolucaoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolucaoButtonActionPerformed
        EmprestimoService service = new EmprestimoService();
        int linhaSelecionada = tabelaEmprestimos.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um empréstimo para devolver!");
            return;
        }
        EmprestimoFormatado em = lista.get(linhaSelecionada);
        service.delete(em.getId());
        JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso!");
        atualizarTabela();
    }//GEN-LAST:event_devolucaoButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        ScreenManager.navegarPara(Tela.INICIAL);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton devolucaoButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollTabelaEmprestimos;
    private javax.swing.JTable tabelaEmprestimos;
    // End of variables declaration//GEN-END:variables
}
