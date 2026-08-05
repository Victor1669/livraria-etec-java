package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.FuncionarioDAO;
import com.victor1669.models.FuncionarioModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioService extends GenericService<FuncionarioModel> {

    @Override
    public void criar(FuncionarioModel fm) throws SQLException {
        String nome = fm.getNome();
        double salario = fm.getSalario();
        String tipo = fm.getTipoFuncionario();

        if (nome == null || nome.isBlank() || salario == 0 || tipo.isBlank()) {
            onInvalid.run();
        }

        Connection conn = ConexaoMySQL.getInstancia().getConexao();

        FuncionarioDAO fdao = new FuncionarioDAO(conn);

        fdao.inserir(fm);

        onSuccess.run();
    }

    @Override
    public List<FuncionarioModel> getItems() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        FuncionarioDAO fdao = new FuncionarioDAO(conn);

        return fdao.selecionarTodos();
    }
}
