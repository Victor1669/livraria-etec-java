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
        if (nome == null || nome.isBlank() || autor == null || autor.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }
        getDao().insert(livro);
        return ValidationResult.SUCCESS;
    }
}
