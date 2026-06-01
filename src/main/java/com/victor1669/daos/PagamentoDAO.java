package com.victor1669.daos;

import com.victor1669.models.Funcionario;
import com.victor1669.models.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagamentoDAO extends AbstractGenericDAO<Pagamento, Integer> {

    public PagamentoDAO(Connection conn) {
        super(conn, "pagamentos");
    }

    public void pagar(Funcionario f) throws SQLException {

        f.setFATOR_BONUS(f.getTipoFuncionario().equals("gerente") ? 0.1 : 0.2);
        f.calcularBonus();
        double totalPago = f.processarPagamento();

        Pagamento pagamento = new Pagamento();
        pagamento.setId_funcionario(f.getId());
        pagamento.setValorTotal((int) totalPago);

        inserir(pagamento);
    }

    @Override
    protected String gerarStringDeInsert() {
        return "INSERT INTO pagamentos (id_funcionario, totalPago) VALUES (?, ?)";
    }

    @Override
    protected void configurarParametrosDeInsert(PreparedStatement ps, Pagamento pagamento) throws SQLException {
        ps.setInt(1, pagamento.getId_funcionario());
        ps.setDouble(2, pagamento.getValorTotal());
    }

    @Override
    protected Pagamento transformarLinhaSQLEmObjeto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int idFuncionario = rs.getInt("id_funcionario");
        int valorTotal = rs.getInt("totalPago");

        return new Pagamento(id, idFuncionario, valorTotal);
    }
}
