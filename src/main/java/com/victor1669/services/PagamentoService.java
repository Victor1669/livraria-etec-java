package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.PagamentoDAO;
import com.victor1669.models.PagamentoModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PagamentoService extends GenericService<PagamentoModel> {

    @Override
    public void criar(PagamentoModel pm) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();

        PagamentoDAO pdao = new PagamentoDAO(conn);

        pdao.inserir(pm);
    }

    @Override
    public List<PagamentoModel> getItems() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        PagamentoDAO pdao = new PagamentoDAO(conn);

        return pdao.selecionarTodos();
    }

}
