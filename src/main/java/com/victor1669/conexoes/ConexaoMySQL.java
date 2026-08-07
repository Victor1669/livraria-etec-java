package com.victor1669.conexoes;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.flywaydb.core.Flyway;

public class ConexaoMySQL {

    private static ConexaoMySQL instancia;
    private Connection conexao;
    private final String URL;
    private final String USUARIO;
    private final String SENHA;
    private final String BANCO;

    public ConexaoMySQL() {
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String usuario = dotenv.get("DB_USER");
        String senha = dotenv.get("DB_PASSWORD");
        String banco = dotenv.get("DB_NAME");

        Flyway flyway = Flyway.configure()
                .dataSource(url, usuario, senha)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();

        flyway.repair();
        flyway.migrate();
        
        if (instancia != null) {
            throw new IllegalStateException("Já existe uma instância de ConexaoMySQL!");
        }
        this.URL = url;
        this.BANCO = banco;
        this.USUARIO = usuario;
        this.SENHA = senha;
        instancia = this;

    }

    public void resetarBanco(Runnable onDelete) {
        try (Statement stmt = conexao.createStatement()) {
            stmt.execute("DROP DATABASE " + BANCO);

            stmt.execute("CREATE DATABASE " + BANCO);

            onDelete.run();
        } catch (SQLException e) {
            System.out.println("Erro ao reiniciar o banco de dados: " + e.getMessage());
        }
    }

    public void usarBanco() throws SQLException {
        conexao.createStatement().execute("USE " + getBANCO());
    }

    // ==================== CONEXÃO ====================
    public void conectar() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            System.err.println("Conexão já ativa!");
            return;
        }
        conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexao fechada!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }

    // ==================== GETTERS ====================
    public static ConexaoMySQL getInstancia() {
        return instancia;
    }

    public Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            conectar();
            usarBanco();
        }
        return conexao;
    }

    public String getBANCO() {
        return BANCO;
    }
}
