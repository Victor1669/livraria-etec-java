package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.FuncionarioDAO;
import com.victor1669.daos.GenericDAO;
import com.victor1669.models.FuncionarioModel;
import java.sql.SQLException;

public class FuncionarioService extends GenericService<FuncionarioModel, Integer> {

    @Override
    protected GenericDAO<FuncionarioModel, Integer> getDao() throws SQLException {
        return new FuncionarioDAO(ConexaoMySQL.getInstancia().getConexao());
    }

    @Override
    public ValidationResult create(FuncionarioModel funcionario) throws SQLException {
        String nome = funcionario.getNome();
        double salario = funcionario.getSalario();
        String tipo = funcionario.getTipoFuncionario();
        if (nome == null || nome.isBlank() || salario == 0 || tipo == null || tipo.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }
        getDao().insert(funcionario);
        return ValidationResult.SUCCESS;
    }
}
