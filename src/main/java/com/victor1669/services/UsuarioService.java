package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.UsuarioDAO;
import com.victor1669.models.UsuarioModel;
import java.sql.SQLException;

public class UsuarioService extends GenericService<UsuarioModel, Integer> {

    @Override
    protected UsuarioDAO getDao() throws SQLException {
        return new UsuarioDAO(ConexaoMySQL.getInstancia().getConexao());
    }

    @Override
    public ValidationResult create(UsuarioModel usuario) throws SQLException {
        String nome = usuario.getNome();
        String senha = usuario.getSenha();
        if (nome == null || nome.isBlank() || senha == null || senha.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }
        getDao().insert(usuario);
        return ValidationResult.SUCCESS;
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
