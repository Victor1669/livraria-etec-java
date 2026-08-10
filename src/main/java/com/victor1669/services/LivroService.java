package com.victor1669.services;

import com.victor1669.services.results.ValidationResult;
import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.models.LivroModel;

public class LivroService extends GenericService<LivroModel, Integer> {

    public LivroService() {
        super(LivroModel.class);
    }

    public ValidationResult cadastrar(LivroModel livro) {
        if (livro.getNome() == null || livro.getNome().isBlank()
                || livro.getAutor() == null || livro.getAutor().isBlank()
                || livro.getQuantidade() == null || livro.getQuantidade() <= 0) {
            return ValidationResult.INVALID_FIELDS;
        }

        super.create(livro);
        return ValidationResult.SUCCESS;
    }

    public ValidationResult emprestarLivro(int id) {
        return ConexaoJPA.getInstancia().execute(em -> {
            em.getTransaction().begin();
            try {
                LivroModel livro = em.find(LivroModel.class, id);

                if (livro == null || livro.getQuantidade() <= 0) {
                    em.getTransaction().rollback();
                    return ValidationResult.INVALID_FIELDS;
                }

                livro.setQuantidade(livro.getQuantidade() - 1);
                em.getTransaction().commit();
                return ValidationResult.SUCCESS;
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        });
    }

    public ValidationResult devolverLivro(int id) {
        return ConexaoJPA.getInstancia().execute(em -> {
            em.getTransaction().begin();
            try {
                LivroModel livro = em.find(LivroModel.class, id);

                if (livro == null) {
                    em.getTransaction().rollback();
                    return ValidationResult.INVALID_FIELDS;
                }

                livro.setQuantidade(livro.getQuantidade() + 1);
                em.getTransaction().commit();
                return ValidationResult.SUCCESS;
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        });
    }
}
