package com.victor1669.daos;

import com.victor1669.classes.Bibliotecario;
import com.victor1669.models.Funcionario;
import com.victor1669.classes.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private final Connection conn;

    public FuncionarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Funcionario funcionario) throws SQLException {
        String query = "INSERT INTO funcionarios (nome, salario, bonus, tipoFuncionario) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, funcionario.getNome());
        ps.setDouble(2, funcionario.getSalario());
        ps.setDouble(3, funcionario.getBonus());
        ps.setString(4, funcionario.getTipoFuncionario());

        ps.executeUpdate();
    }

    public List<Funcionario> selecionarTodos() throws SQLException {
        String query = "SELECT * FROM funcionarios";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        List<Funcionario> lista = new ArrayList<>();

        while (rs.next()) {
            String tipoFuncionario = rs.getString("tipoFuncionario");

            Funcionario f = tipoFuncionario.equals("gerente")
                    ? new Gerente()
                    : new Bibliotecario();

            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setSalario(rs.getDouble("salario"));
            f.setTipoFuncionario(tipoFuncionario);

            lista.add(f);
        }
        
        return lista;
    }
}
