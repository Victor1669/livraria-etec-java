package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.EmprestimoDAO;
import com.victor1669.models.EmprestimoFormatado;
import com.victor1669.models.EmprestimoModel;
import java.sql.SQLException;
import java.util.List;

public class EmprestimoService extends GenericService<EmprestimoModel, Integer> {

    @Override
    protected EmprestimoDAO getDao() throws SQLException {
        return new EmprestimoDAO(ConexaoMySQL.getInstancia().getConexao());
    }

    @Override
    public ValidationResult create(EmprestimoModel emprestimo) throws SQLException {
        int id_usuario = emprestimo.getId_usuario();
        int id_livro = emprestimo.getId_livro();
        if (id_usuario == -1 || id_livro == -1) {
            return ValidationResult.INVALID_FIELDS;
        }
        getDao().insert(emprestimo);
        return ValidationResult.SUCCESS;
    }

    public List<EmprestimoFormatado> getAllEmprestimos(String nome) throws SQLException {
        return getDao().selectAllEmprestimosWithNames(nome);
    }
}
