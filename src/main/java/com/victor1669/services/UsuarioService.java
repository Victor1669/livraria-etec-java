package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.UsuarioDAO;
import com.victor1669.models.UsuarioModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService extends GenericService<UsuarioModel> {

    @Override
    public void criar(UsuarioModel um) throws SQLException {
        String nome = um.getNome();
        String senha = um.getSenha();

        if (nome == null || nome.isBlank() || senha == null || senha.isBlank()) {
            onInvalid.run();
            return;
        }

        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        UsuarioDAO udao = new UsuarioDAO(conn);

        udao.inserir(um);

        onSuccess.run();
    }

    @Override
    public List<UsuarioModel> getItems() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        UsuarioDAO udao = new UsuarioDAO(conn);

        return udao.selecionarTodos();
    }
    
    @Override
    public void deleteItem(int itemId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public UsuarioModel getUserById(int id) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        UsuarioDAO udao = new UsuarioDAO(conn);

        return udao.selecionarPorCampo("id", Integer.toString(id));
    }

    public UsuarioModel getUserByName(String name) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        UsuarioDAO udao = new UsuarioDAO(conn);

        return udao.selecionarPorCampo("nome", name);
    }

    public void login(String nome, String senha) throws SQLException {
        if (nome == null || nome.isBlank() || senha == null || senha.isBlank()) {
            onInvalid.run();
            return;
        }

        UsuarioModel user = getUserByName(nome);

        if (user != null) {
            if (user.getSenha().equals(senha)) {
                onSuccess.run();
            } else {
                throw new SQLException("Senha incorreta!");
            }
        } else {
            throw new SQLException("Usuário não existente");
        }
    }
}
