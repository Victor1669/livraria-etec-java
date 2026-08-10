package com.victor1669.daos;

import com.victor1669.models.EmprestimoFormatado;
import com.victor1669.models.EmprestimoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO extends GenericDAO<EmprestimoModel, Integer> {

    public EmprestimoDAO(Connection conn) {
        super(conn, "emprestimos");
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO " + tableName + " (id_usuario, id_livro) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement ps, EmprestimoModel emprestimo) throws SQLException {
        ps.setInt(1, emprestimo.getId_usuario());
        ps.setInt(2, emprestimo.getId_livro());
    }

    @Override
    protected EmprestimoModel mapRowToEntity(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int id_usuario = rs.getInt("id_usuario");
        int id_livro = rs.getInt("id_livro");
        String dataEmprestimo = rs.getString("data_emprestimo");
        return new EmprestimoModel(id, id_usuario, id_livro, dataEmprestimo);
    }

    // MÉTODOS ADAPTADOS PARA O MODEL FORMATADO
    protected EmprestimoFormatado mapRowToFormattedEntity(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome_usuario = rs.getString("nome_usuario");
        String nome_livro = rs.getString("nome_livro");
        String dataEmprestimo = rs.getString("data_emprestimo");
        return new EmprestimoFormatado(id, nome_usuario, nome_livro, dataEmprestimo);
    }

    public List<EmprestimoFormatado> selectAllEmprestimosWithNames(String nome) throws SQLException {
        String sql = """
                 SELECT em.id AS id, u.nome AS nome_usuario, l.nome AS nome_livro, em.data_emprestimo
                 FROM emprestimos em
                 JOIN usuarios u
                 \tON em.id_usuario = u.id
                 JOIN livros l 
                 \tON em.id_livro = l.id
                 WHERE (? IS NULL OR u.nome = ?);""";
        List<EmprestimoFormatado> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToFormattedEntity(rs));
                }
            }
        }
        return list;
    }
}
