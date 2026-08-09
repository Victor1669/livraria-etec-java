package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.UsuarioDAO;
import com.victor1669.models.UsuarioModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService extends GenericService<UsuarioModel> {

    @Override
    public ValidationResult create(UsuarioModel usuario) throws SQLException {
        String nome = usuario.getNome();
        String senha = usuario.getSenha();
        if (nome == null || nome.isBlank() || senha == null || senha.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        usuarioDAO.insert(usuario);
        return ValidationResult.SUCCESS;
    }

    @Override
    public List<UsuarioModel> getAll() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        List<UsuarioModel> lista = usuarioDAO.selectAll();
        return lista != null ? lista : new ArrayList<>();
    }

    @Override
    public void delete(int itemId) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        usuarioDAO.delete(itemId);
    }

    @Override
    public UsuarioModel getByField(String field, String value) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);

        return usuarioDAO.selectByField(field, value);
    }

    public LoginResult login(String nome, String senha) throws SQLException {
        if (nome == null || nome.isBlank() || senha == null || senha.isBlank()) {
            return LoginResult.INVALID_FIELDS;
        }
        UsuarioModel user = getByField("nome", nome);
        if (user == null) {
            return LoginResult.USER_NOT_FOUND;
        }
        if (!user.getSenha().equals(senha)) {
            return LoginResult.WRONG_PASSWORD;
        }
        return LoginResult.SUCCESS;
    }

}
