package com.victor1669.daos;

import com.victor1669.models.EmprestimoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmprestimoDAO extends GenericDAO<EmprestimoModel, Integer> {

    public EmprestimoDAO(Connection conn) {
        super(conn, "emprestimos");
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO " + tableName + " (nome_usuario, nome_livro) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement ps, EmprestimoModel emprestimo) throws SQLException {
        ps.setString(1, emprestimo.getNome_usuario());
        ps.setString(2, emprestimo.getNome_livro());
    }

    @Override
    protected EmprestimoModel mapRowToEntity(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nomeUsuario = rs.getString("nome_usuario");
        String nomeLivro = rs.getString("nome_livro");
        String dataEmprestimo = rs.getString("data_emprestimo");
        return new EmprestimoModel(id, nomeUsuario, nomeLivro, dataEmprestimo);
    }
}
