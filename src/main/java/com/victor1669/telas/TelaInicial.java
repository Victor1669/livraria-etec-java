package com.victor1669.telas;

import com.victor1669.conexoes.ConexaoMySQL;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor1669
 */
public final class TelaInicial extends javax.swing.JPanel {

    public TelaInicial() {
        initComponents();

        configureLinks();

    }

    void configureLinks() {
        JButton[] links = {emprestimoLink, funcionarioLink, livroLink, pagamentoLink, usuariosLink};
        String[] nomesPaginas = {"EMPRESTIMO", "FUNCIONARIO", "LIVROS", "PAGAMENTO", "CONSULTA"};
        ArrayList<Dimension> tamanhos = new ArrayList<>(List.of(
                new Dimension(954, 532),
                new Dimension(772, 562),
                new Dimension(772, 562),
                new Dimension(683, 539),
                new Dimension(551, 607)
        ));

        for (int c = 0; c < links.length; c++) {
            JButton link = links[c];
            String nomePagina = nomesPaginas[c];
            Dimension novoTamanho = tamanhos.get(c);

            link.addActionListener(e -> {
                MainForm.mostrarTela(nomePagina);
                MainForm.resizeTela(novoTamanho);
            });
        }
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
        emprestimoLink.setText("Empréstimo");

        resetDatabase.setBackground(new java.awt.Color(255, 102, 102));
        resetDatabase.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetDatabase.setForeground(new java.awt.Color(0, 0, 0));
        resetDatabase.setText("Resetar Banco de dados");
        resetDatabase.addActionListener(this::resetDatabaseActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emprestimoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(livroLink, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usuariosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(funcionarioLink, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pagamentoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(resetDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagamentoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funcionarioLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livroLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariosLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(emprestimoLink, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(resetDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
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
