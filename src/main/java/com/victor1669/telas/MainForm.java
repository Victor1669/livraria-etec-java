package com.victor1669.telas;

// VARIÁVEIS DE AMBIENTE
import io.github.cdimascio.dotenv.Dotenv;

// VISUAL
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

// MIGRATIONS
import org.flywaydb.core.Flyway;

// BANCO
import java.sql.SQLException;
import com.victor1669.conexoes.*;

public class MainForm extends javax.swing.JFrame {

    public static CardLayout cardLayout;
    public static JPanel container;
    static MainForm instancia;

    // ==================== UTILITÁRIOS PARA MUDANÇA DE TELA ====================
    public static void mostrarTela(String nomeTela) {
        instancia.setTitle(nomeTela);

        cardLayout.show(container, nomeTela);
    }

    public static void resizeTela(Dimension novoTamanho) {
        instancia.setSize(novoTamanho);
        instancia.setLocationRelativeTo(null);
        instancia.revalidate();
        instancia.repaint();
    }

    public static void voltarTelaInicial() {
        cardLayout.show(MainForm.container, "TELA_INICIAL");
        instancia.setTitle("Livraria ETEC");
        resizeTela(new Dimension(430, 580));
    }

    // ==================== INICIALIZAÇÃO ====================
    public static void main(String args[]) {
        connectMySQL();

        MainForm form = new MainForm();

        instancia = form;

        java.awt.EventQueue.invokeLater(() -> form.setVisible(true));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConexaoMySQL.getInstancia().fecharConexao();
        }));
    }

    static final void connectMySQL() {
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String usuario = dotenv.get("DB_USER");
        String senha = dotenv.get("DB_PASSWORD");

        Flyway flyway = Flyway.configure()
                .dataSource(url, usuario, senha)
                .locations("classpath:db/migration")
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

    public MainForm() {
        initComponents();

        mountComponents();

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

    final void mountComponents() {
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        container.add(new TelaInicial(), "TELA_INICIAL");
        container.add(new FuncionarioPanel(), "FUNCIONARIO");
        container.add(new Pagamento(), "PAGAMENTO");
        container.add(new Livros(), "LIVROS");
        container.add(new Emprestimos(), "EMPRESTIMO");
        container.add(new Consulta(), "CONSULTA");
        container.add(new Usuarios(), "USUARIOS");

        cardLayout.show(container, "TELA_INICIAL");

        getContentPane().setLayout(new BorderLayout());

        add(container, BorderLayout.CENTER);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
