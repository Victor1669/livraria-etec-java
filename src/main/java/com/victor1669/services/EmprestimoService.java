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
        int idUsuario = emprestimo.getId_usuario();
        int idLivro = emprestimo.getId_livro();
        if (idUsuario == -1 || idLivro == -1) {
            return ValidationResult.INVALID_FIELDS;
        }
        LivroService livroService = new LivroService();
        ValidationResult resultadoEmprestimo = livroService.emprestarLivro(idLivro);
        if (resultadoEmprestimo == ValidationResult.INVALID_FIELDS) {
            return ValidationResult.INVALID_FIELDS;
        }
        getDao().insert(emprestimo);
        return ValidationResult.SUCCESS;
    }

    @Override
    public void delete(Integer itemId) throws SQLException {
        EmprestimoModel emprestimo = getByField("id", Integer.toString(itemId));
        if (emprestimo == null) {
            return;
        }
        LivroService livroService = new LivroService();
        livroService.devolverLivro(emprestimo.getId_livro());
        super.delete(itemId);
    }

    public List<EmprestimoFormatado> getAllEmprestimos(String nome) throws SQLException {
        return getDao().selectAllEmprestimosWithNames(nome);
    }
}
