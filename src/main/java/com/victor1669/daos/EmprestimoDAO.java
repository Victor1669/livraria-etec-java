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
        return "INSERT INTO " + tableName + " (id_usuario, nome_livro) VALUES (?, ?)";
    }

    @Override
    protected void configurarParametrosDeInsert(PreparedStatement ps, EmprestimoModel em) throws SQLException {
        ps.setInt(1, em.getId_usuario());
        ps.setString(2, em.getNome_livro());
    }

    @Override
    protected EmprestimoModel transformarLinhaSQLEmObjeto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int id_usuario = rs.getInt("id_usuario");
        String nome_livro = rs.getString("nome_livro");

        return new EmprestimoModel(id, id_usuario, nome_livro);
    }
}