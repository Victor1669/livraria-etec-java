package com.victor1669.telas;

import com.victor1669.dtos.EmprestimoFormatado;
import com.victor1669.models.UsuarioModel;
import com.victor1669.services.EmprestimoService;
import com.victor1669.services.UsuarioService;
import com.victor1669.utils.ScreenManager;
import com.victor1669.utils.SessionManager;
import com.victor1669.utils.Tela;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class TelaUsuarios extends javax.swing.JPanel {

    List<UsuarioModel> listaUsuarios;

    public TelaUsuarios() {
        initComponents();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                atualizarTabela();
            }

        });
    }

    void atualizarTabela() {
        UsuarioService service = new UsuarioService();

        try {
            listaUsuarios = service.listarTodos();

            String[] colunas = {"ID", "Nome"};
            DefaultTableModel model = new DefaultTableModel(colunas, 0);

            for (UsuarioModel um : listaUsuarios) {
                Object[] linha = {um.getId(), um.getNome()};
                model.addRow(linha);
            }

            tabelaUsuarios.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        consultarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(954, 526));

        tabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabelaUsuarios);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Consulta");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Selecione o Usuário");

        consultarButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        consultarButton.setText("Consultar");
        consultarButton.addActionListener(this::consultarButtonActionPerformed);

        cancelarButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(this::cancelarButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelarButton)
                                .addGap(18, 18, 18)
                                .addComponent(consultarButton)))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarButton)
                    .addComponent(cancelarButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        ScreenManager.navegarPara(Tela.INICIAL);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        EmprestimoService empService = new EmprestimoService();

        UsuarioModel um = listaUsuarios.get(tabelaUsuarios.getSelectedRow());

        String userName = um.getNome();

        List<EmprestimoFormatado> ems = empService.getEmprestimosByName(userName);

        boolean hasLivros = !ems.isEmpty();

        String listaLivros = ems.stream()
                .map(em -> "<li>" + em.getNomeLivro() + "</li>")
                .collect(Collectors.joining());

        String mensagemHtml = "<html><head><style>*{margin: 0; padding: 0; box-sizing: border-box;}</style></head><body style='width: 400px;'>"
                + "<h1>" + userName + "</h1>"
                + "<h2>Total de livros emprestados: " + ems.size() + "</h2>"
                + (hasLivros
                        ? ("<h3>Livros:</h3>" + "<ul style='list-style-type: none;'>" + listaLivros + "</ul>")
                        : "")
                + "<h3>Tipo de usuário: " + um.getRole() + "</h3>"
                + "</body></html>";

        JLabel label = new JLabel(mensagemHtml);

        JOptionPane.showMessageDialog(
                null,
                label,
                "Detalhes",
                JOptionPane.INFORMATION_MESSAGE
        );


    }//GEN-LAST:event_consultarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUsuarios;
    // End of variables declaration//GEN-END:variables
}
