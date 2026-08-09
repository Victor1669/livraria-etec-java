package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.EmprestimoDAO;
import com.victor1669.models.EmprestimoModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService extends GenericService<EmprestimoModel> {

    @Override
    public ValidationResult create(EmprestimoModel emprestimo) throws SQLException {
        String nomeUsuario = emprestimo.getNome_usuario();
        String nomeLivro = emprestimo.getNome_livro();
        if (nomeUsuario == null || nomeUsuario.isBlank() || nomeLivro == null || nomeLivro.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conn);
        emprestimoDAO.insert(emprestimo);
        return ValidationResult.SUCCESS;
    }

    @Override
    public List<EmprestimoModel> getAll() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conn);
        List<EmprestimoModel> lista = emprestimoDAO.selectAll();
        return lista != null ? lista : new ArrayList<>();
    }

    @Override
    public void delete(int itemId) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conn);
        emprestimoDAO.delete(itemId);
    }

    @Override
    public EmprestimoModel getByField(String field, String value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
