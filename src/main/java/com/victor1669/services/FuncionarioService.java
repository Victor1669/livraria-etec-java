package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.FuncionarioDAO;
import com.victor1669.models.FuncionarioModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioService extends GenericService<FuncionarioModel> {

    @Override
    public ValidationResult create(FuncionarioModel funcionario) throws SQLException {
        String nome = funcionario.getNome();
        double salario = funcionario.getSalario();
        String tipo = funcionario.getTipoFuncionario();
        if (nome == null || nome.isBlank() || salario == 0 || tipo == null || tipo.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);
        funcionarioDAO.insert(funcionario);
        return ValidationResult.SUCCESS;
    }

    @Override
    public List<FuncionarioModel> getAll() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);
        List<FuncionarioModel> lista = funcionarioDAO.selectAll();
        return lista != null ? lista : new ArrayList<>();
    }

    @Override
    public void delete(int itemId) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);
        funcionarioDAO.delete(itemId);
    }

    @Override
    public FuncionarioModel getByField(String field, String value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
