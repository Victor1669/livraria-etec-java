package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.LivroDAO;
import com.victor1669.models.LivroModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroService extends GenericService<LivroModel> {

    @Override
    public ValidationResult create(LivroModel livro) throws SQLException {
        String nome = livro.getNome();
        String autor = livro.getAutor();
        if (nome == null || nome.isBlank() || autor == null || autor.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        LivroDAO livroDAO = new LivroDAO(conn);
        livroDAO.insert(livro);
        return ValidationResult.SUCCESS;
    }

    @Override
    public List<LivroModel> getAll() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        LivroDAO livroDAO = new LivroDAO(conn);
        List<LivroModel> lista = livroDAO.selectAll();
        return lista != null ? lista : new ArrayList<>();
    }

    @Override
    public void delete(int itemId) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        LivroDAO livroDAO = new LivroDAO(conn);
        livroDAO.delete(itemId);
    }

    @Override
    public LivroModel getByField(String field, String value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
