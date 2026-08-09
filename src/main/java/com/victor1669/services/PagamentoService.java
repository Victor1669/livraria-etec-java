package com.victor1669.services;

import com.victor1669.conexoes.ConexaoMySQL;
import com.victor1669.daos.PagamentoDAO;
import com.victor1669.models.PagamentoModel;
import java.sql.SQLException;

public class PagamentoService extends GenericService<PagamentoModel, Integer> {

    @Override
    protected PagamentoDAO getDao() throws SQLException {
        return new PagamentoDAO(ConexaoMySQL.getInstancia().getConexao());
    }

    @Override
    public ValidationResult create(PagamentoModel pagamento) throws SQLException {
        if (pagamento.getId_funcionario() <= 0 || pagamento.getValorTotal() < 0) {
            return ValidationResult.INVALID_FIELDS;
        }
        getDao().insert(pagamento);
        return ValidationResult.SUCCESS;
    }
}
