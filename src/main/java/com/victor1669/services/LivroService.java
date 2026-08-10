package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.LivroDAO;
import com.victor1669.models.LivroModel;
import java.sql.SQLException;

public class LivroService extends GenericService<LivroModel, Integer> {

    @Override
    protected LivroDAO getDao() throws SQLException {
        return new LivroDAO(ConexaoMySQL.getInstancia().getConexao());
    }

    @Override
    public ValidationResult create(LivroModel livro) throws SQLException {
        String nome = livro.getNome();
        String autor = livro.getAutor();
        int quantidade = livro.getQuantidade();
        if (nome == null || nome.isBlank() || autor == null || autor.isBlank() || quantidade <= 0) {
            return ValidationResult.INVALID_FIELDS;
        }
        getDao().insert(livro);
        return ValidationResult.SUCCESS;
    }

    public ValidationResult emprestarLivro(int id) throws SQLException {
        LivroModel livro = getByField("id", Integer.toString(id));
        if (livro == null || livro.getQuantidade() <= 0) {
            return ValidationResult.INVALID_FIELDS;
        }
        UpdateParam[] params = new UpdateParam[]{
            new UpdateParam("quantidade", Integer.toString(livro.getQuantidade() - 1))
        };
        getDao().update(id, params);
        return ValidationResult.SUCCESS;
    }

    public ValidationResult devolverLivro(int id) throws SQLException {
        LivroModel livro = getByField("id", Integer.toString(id));
        if (livro == null) {
            return ValidationResult.INVALID_FIELDS;
        }
        UpdateParam[] params = new UpdateParam[]{
            new UpdateParam("quantidade", Integer.toString(livro.getQuantidade() + 1))
        };
        getDao().update(id, params);
        return ValidationResult.SUCCESS;
    }
}
