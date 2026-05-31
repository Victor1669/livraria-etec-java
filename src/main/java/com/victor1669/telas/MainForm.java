package com.victor1669.telas;

import io.github.cdimascio.dotenv.Dotenv;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import org.flywaydb.core.Flyway;
import java.sql.SQLException;
import com.victor1669.conexoes.*;
import com.victor1669.ui.ScreenManager;
import com.victor1669.ui.Tela;

/**
 *
 * @author Victor1669
 */
public class MainForm extends javax.swing.JFrame {

    private static CardLayout cardLayout;
    private static JPanel container;

    public MainForm() {
        initComponents();
        mountComponents();
    }

    final void mountComponents() {
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        container.add(new TelaInicial(), Tela.INICIAL.getNome());
        container.add(new TelaFuncionarios(), Tela.FUNCIONARIO.getNome());
        container.add(new TelaPagamento(), Tela.PAGAMENTO.getNome());
        container.add(new Livros(), Tela.LIVROS.getNome());
        container.add(new Emprestimos(), Tela.EMPRESTIMO.getNome());
        container.add(new Consulta(), Tela.CONSULTA.getNome());
        container.add(new Usuarios(), Tela.USUARIOS.getNome());

        getContentPane().setLayout(new BorderLayout());
        add(container, BorderLayout.CENTER);

        ScreenManager.inicializar(this, container, cardLayout);
        ScreenManager.navegarPara(Tela.INICIAL);
    }

    static final void connectMySQL() {
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String usuario = dotenv.get("DB_USER");
        String senha = dotenv.get("DB_PASSWORD");

        Flyway flyway = Flyway.configure()
                .dataSource(url, usuario, senha)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();

        ConexaoMySQL conexaoMySQL = new ConexaoMySQL("localhost:3306", "livrariaJava", usuario, senha);
        try {
            conexaoMySQL.conectar();
            conexaoMySQL.usarBanco();
            System.out.println("Conectou com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar no MySQL: " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        connectMySQL();

        MainForm form = new MainForm();

        java.awt.EventQueue.invokeLater(() -> form.setVisible(true));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConexaoMySQL.getInstancia().fecharConexao();
        }));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Livraria ETEC");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
