package com.victor1669.telas;

import com.victor1669.models.PagamentoModel;
import com.victor1669.services.PagamentoService;
import com.victor1669.ui.ScreenManager;
import com.victor1669.ui.Tela;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class TelaPagamento extends javax.swing.JPanel {

    public TelaPagamento() {
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
        scrollTabelaPagamentos = new javax.swing.JScrollPane();
        tabelaPagamentos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Extrato de Pagamento");

        tabelaPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Funcionario", "Total pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
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
        scrollTabelaPagamentos.setViewportView(tabelaPagamentos);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Total Geral");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(255, 0, 0));
        totalLabel.setText("0");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(658, 658, 658)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollTabelaPagamentos))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(scrollTabelaPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ScreenManager.navegarPara(Tela.INICIAL);
    }//GEN-LAST:event_jButton2ActionPerformed

    void atualizarTabela() {
        PagamentoService service = new PagamentoService();

        try {
            List<PagamentoModel> lista = service.getItems();

            int total = lista.stream().mapToInt(PagamentoModel::getValorTotal).sum();

            totalLabel.setText(Integer.toString(total));

            String[] colunas = {"ID", "ID_Funcionario", "Total pago"};
            DefaultTableModel model = new DefaultTableModel(colunas, 0);

            for (PagamentoModel p : lista) {
                Object[] linha = {p.getId(), p.getId_funcionario(), p.getValorTotal()};
                model.addRow(linha);
            }

            tabelaPagamentos.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados: " + e.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scrollTabelaPagamentos;
    private javax.swing.JTable tabelaPagamentos;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
