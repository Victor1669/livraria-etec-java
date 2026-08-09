package com.victor1669.daos;

import com.victor1669.models.PagamentoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagamentoDAO extends GenericDAO<PagamentoModel, Integer> {

    public PagamentoDAO(Connection conn) {
        super(conn, "pagamentos");
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO " + tableName + " (id_funcionario, totalPago) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement ps, PagamentoModel pagamento) throws SQLException {
        ps.setInt(1, pagamento.getId_funcionario());
        ps.setDouble(2, pagamento.getValorTotal());
    }

    @Override
    protected PagamentoModel mapRowToEntity(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int idFuncionario = rs.getInt("id_funcionario");
        int valorTotal = rs.getInt("totalPago");

        return new PagamentoModel(id, idFuncionario, valorTotal);
    }
}
