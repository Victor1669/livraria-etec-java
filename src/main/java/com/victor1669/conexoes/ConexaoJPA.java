package com.victor1669.conexoes;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import org.flywaydb.core.Flyway;

public class ConexaoJPA {

    private static ConexaoJPA instancia;
    private EntityManagerFactory emf;
    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    private ConexaoJPA() {
        Dotenv dotenv = Dotenv.load();
        this.dbUrl = dotenv.get("DB_URL");
        this.dbUser = dotenv.get("DB_USER");
        this.dbPassword = dotenv.get("DB_PASSWORD");
        migrarBanco();
        this.emf = criarEntityManagerFactory();
    }

    public static ConexaoJPA getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoJPA();
        }
        return instancia;
    }

    private void migrarBanco() {
        Flyway flyway = Flyway.configure()
                .dataSource(dbUrl, dbUser, dbPassword)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();
        flyway.repair();
        flyway.migrate();
    }

    private EntityManagerFactory criarEntityManagerFactory() {
        Map<String, String> overrides = new HashMap<>();
        overrides.put("jakarta.persistence.jdbc.url", dbUrl);
        overrides.put("jakarta.persistence.jdbc.user", dbUser);
        overrides.put("jakarta.persistence.jdbc.password", dbPassword);
        return Persistence.createEntityManagerFactory("livrariaJava", overrides);
    }

    public void resetarBanco(Runnable onReset) {
        emf.close();
        Flyway flyway = Flyway.configure()
                .dataSource(dbUrl, dbUser, dbPassword)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();
        flyway.clean();
        flyway.migrate();
        this.emf = criarEntityManagerFactory();
        onReset.run();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void encerrar() {
        if (emf.isOpen()) {
            emf.close();
        }
    }

    public <T> T execute(java.util.function.Function<EntityManager, T> action) {
        try (EntityManager em = getEntityManager()) {
            return action.apply(em);
        }
    }

    public void executeInTransaction(java.util.function.Consumer<EntityManager> action) {
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            try {
                action.accept(em);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        }
    }
}
