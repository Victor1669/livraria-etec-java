package com.victor1669.daos;

import com.victor1669.models.Bibliotecario;
import com.victor1669.models.FuncionarioModel;
import com.victor1669.models.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO extends GenericDAO<FuncionarioModel, Integer> {

    public FuncionarioDAO(Connection conn) {
        super(conn, "funcionarios");
    }

    @Override
    protected String buildInsertQuery() {
        return "INSERT INTO " + tableName + " (nome, salario, tipoFuncionario) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement ps, FuncionarioModel funcionario) throws SQLException {
        ps.setString(1, funcionario.getNome());
        ps.setDouble(2, funcionario.getSalario());
        ps.setString(3, funcionario.getTipoFuncionario());
    }

    @Override
    protected FuncionarioModel mapRowToEntity(ResultSet rs) throws SQLException {
        String tipoFuncionario = rs.getString("tipoFuncionario");

        FuncionarioModel funcionario = tipoFuncionario.equalsIgnoreCase("gerente")
                ? new Gerente()
                : new Bibliotecario();

        funcionario.setId(rs.getInt("id"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setSalario(rs.getDouble("salario"));
        funcionario.setTipoFuncionario(tipoFuncionario);

        return funcionario;
    }
}
