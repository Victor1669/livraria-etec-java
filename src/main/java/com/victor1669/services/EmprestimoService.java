package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.EmprestimoDAO;
import com.victor1669.daos.GenericDAO;
import com.victor1669.models.EmprestimoModel;
import java.sql.SQLException;

public class EmprestimoService extends GenericService<EmprestimoModel, Integer> {

    @Override
    protected GenericDAO<EmprestimoModel, Integer> getDao() throws SQLException {
        return new EmprestimoDAO(ConexaoMySQL.getInstancia().getConexao());
    }

    @Override
    public ValidationResult create(EmprestimoModel emprestimo) throws SQLException {
        String nomeUsuario = emprestimo.getNome_usuario();
        String nomeLivro = emprestimo.getNome_livro();
        if (nomeUsuario == null || nomeUsuario.isBlank() || nomeLivro == null || nomeLivro.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }
        getDao().insert(emprestimo);
        return ValidationResult.SUCCESS;
    }
}
