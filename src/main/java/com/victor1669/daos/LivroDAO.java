package com.victor1669.daos;

import com.victor1669.models.LivroModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO extends AbstractGenericDAO<LivroModel, Integer> {

    public LivroDAO(Connection conn) {
        super(conn, "livros");
    }

    @Override
    protected String gerarStringDeInsert() {
        return "INSERT INTO " + tableName + " (nome, autor) VALUES (?, ?)";
    }

    @Override
    protected void configurarParametrosDeInsert(PreparedStatement ps, LivroModel livro) throws SQLException {
        ps.setString(1, livro.getNome());
        ps.setString(2, livro.getAutor());
    }

    @Override
    protected LivroModel transformarLinhaSQLEmObjeto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String autor = rs.getString("autor");

        LivroModel livro = new LivroModel(id, nome, autor);

        return livro;

    }

}
