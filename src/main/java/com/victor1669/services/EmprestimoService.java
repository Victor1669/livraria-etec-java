package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.EmprestimoDAO;
import com.victor1669.models.EmprestimoModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmprestimoService extends GenericService<EmprestimoModel> {

    @Override
    public void criar(EmprestimoModel em) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        EmprestimoDAO edao = new EmprestimoDAO(conn);

        edao.inserir(em);

        if (onSuccess != null) {
            onSuccess.run();
        }
    }

    @Override
    public List<EmprestimoModel> getItems() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        EmprestimoDAO edao = new EmprestimoDAO(conn);

        return edao.selecionarTodos();
    }

    @Override
    public void deleteItem(int itemId) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        EmprestimoDAO edao = new EmprestimoDAO(conn);

        edao.deletar(itemId);
        
        onSuccess.run();
    }

}
