package com.victor1669.daos;

import com.victor1669.models.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends AbstractGenericDAO<UsuarioModel, Integer> {

    public UsuarioDAO(Connection conn) {
        super(conn, "usuarios");
    }

    @Override
    protected String gerarStringDeInsert() {
        return "INSERT INTO " + tableName + " (nome, senha) VALUES (?, ?)";
    }

    @Override
    protected void configurarParametrosDeInsert(PreparedStatement ps, UsuarioModel usuario) throws SQLException {
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getSenha());
    }

    @Override
    protected UsuarioModel transformarLinhaSQLEmObjeto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String senha = rs.getString("senha");

        return new UsuarioModel(id, nome, senha);
    }

}
