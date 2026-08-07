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
    protected String gerarStringDeInsert() {
        return "INSERT INTO " + tableName + " (nome_usuario, nome_livro) VALUES (?, ?)";
    }

    @Override
    protected void configurarParametrosDeInsert(PreparedStatement ps, EmprestimoModel em) throws SQLException {
        ps.setString(1, em.getNome_usuario());
        ps.setString(2, em.getNome_livro());
    }

    @Override
    protected EmprestimoModel transformarLinhaSQLEmObjeto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome_usuario = rs.getString("nome_usuario");
        String nome_livro = rs.getString("nome_livro");
        String data_emprestimo = rs.getString("data_emprestimo");

        return new EmprestimoModel(id, nome_usuario, nome_livro, data_emprestimo);
    }
}
