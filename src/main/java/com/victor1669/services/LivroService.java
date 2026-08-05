package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.LivroDAO;
import com.victor1669.models.LivroModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LivroService extends GenericService<LivroModel> {

    @Override
    public void criar(LivroModel lm) throws SQLException {
        String nome = lm.getNome();
        String autor = lm.getAutor();

        if (nome == null || nome.isBlank() || autor == null || autor.isBlank()) {
            onInvalid.run();
            return;
        }

        Connection conn = ConexaoMySQL.getInstancia().getConexao();

        var ldao = new LivroDAO(conn);

        ldao.inserir(lm);

        onSuccess.run();
    }

    @Override
    public List<LivroModel> getItems() throws SQLException {
        try {
            Connection conn = ConexaoMySQL.getInstancia().getConexao();
            var ldao = new LivroDAO(conn);

            List<LivroModel> lista = ldao.selecionarTodos();

            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
}
