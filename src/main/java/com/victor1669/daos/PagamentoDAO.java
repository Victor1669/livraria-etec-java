package com.victor1669.daos;

import com.victor1669.models.Funcionario;
import com.victor1669.models.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor1669
 */
public class PagamentoDAO {

    private final Connection conn;

    public PagamentoDAO(Connection conn) {
        this.conn = conn;
    }

    public void pagar(Funcionario f) throws SQLException {
        String query = "INSERT INTO pagamentos (id_funcionario, totalPago) VALUES (?, ?)";

        int id_funcionario = f.getId();
        
        f.setFATOR_BONUS(f.getTipoFuncionario().equals("gerente") ? 0.1 : 0.2);
        f.calcularBonus();
        double totalPago = f.processarPagamento();

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id_funcionario);
        ps.setDouble(2, totalPago);

        ps.executeUpdate();
    }

    public List<Pagamento> selecionarTodos() throws SQLException {
        String query = "SELECT * FROM pagamentos";

        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        List<Pagamento> lista = new ArrayList<>();

        while (rs.next()) {
            int id_funcionario = rs.getInt("id_funcionario");
            int valorTotal = rs.getInt("totalPago");
            int id = rs.getInt("id");

            Pagamento p = new Pagamento(id, id_funcionario, valorTotal);

            lista.add(p);
        }

        return lista;
    }
}
