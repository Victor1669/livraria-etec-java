package com.victor1669.daos;

import com.victor1669.classes.Bibliotecario;
import com.victor1669.models.FuncionarioModel;
import com.victor1669.classes.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO extends AbstractGenericDAO<FuncionarioModel, Integer> {

    public FuncionarioDAO(Connection conn) {
        super(conn, "funcionarios");
    }

    @Override
    protected String gerarStringDeInsert() {
        return "INSERT INTO funcionarios (nome, salario, bonus, tipoFuncionario) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected void configurarParametrosDeInsert(PreparedStatement ps, FuncionarioModel funcionario) throws SQLException {
        ps.setString(1, funcionario.getNome());
        ps.setDouble(2, funcionario.getSalario());
        ps.setDouble(3, funcionario.getBonus());
        ps.setString(4, funcionario.getTipoFuncionario());
    }

    @Override
    protected FuncionarioModel transformarLinhaSQLEmObjeto(ResultSet rs) throws SQLException {
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