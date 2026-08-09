package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.PagamentoDAO;
import com.victor1669.models.PagamentoModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoService extends GenericService<PagamentoModel> {

    @Override
    public ValidationResult create(PagamentoModel pagamento) throws SQLException {
        if (pagamento.getId_funcionario() <= 0 || pagamento.getValorTotal() < 0) {
            return ValidationResult.INVALID_FIELDS;
        }
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        PagamentoDAO pagamentoDAO = new PagamentoDAO(conn);
        pagamentoDAO.insert(pagamento);
        return ValidationResult.SUCCESS;
    }

    @Override
    public List<PagamentoModel> getAll() throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        PagamentoDAO pagamentoDAO = new PagamentoDAO(conn);
        List<PagamentoModel> lista = pagamentoDAO.selectAll();
        return lista != null ? lista : new ArrayList<>();
    }

    @Override
    public void delete(int itemId) throws SQLException {
        Connection conn = ConexaoMySQL.getInstancia().getConexao();
        PagamentoDAO pagamentoDAO = new PagamentoDAO(conn);
        pagamentoDAO.delete(itemId);
    }

    @Override
    public PagamentoModel getByField(String field, String value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
