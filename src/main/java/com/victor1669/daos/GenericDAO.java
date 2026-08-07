package com.victor1669.daos;

import com.victor1669.interfaces.IGenericDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T, ID> implements IGenericDAO<T, ID> {

    protected final Connection conn;
    protected final String tableName;

    public GenericDAO(Connection conn, String tableName) {
        this.conn = conn;
        this.tableName = tableName;
    }

    @Override
    public void inserir(T entity) throws SQLException {
        String sql = gerarStringDeInsert();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            configurarParametrosDeInsert(ps, entity);
            ps.executeUpdate();
        }
    }

    @Override
    public List<T> selecionarTodos() throws SQLException {
        String sql = "SELECT * FROM " + tableName;
        List<T> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(transformarLinhaSQLEmObjeto(rs));
            }
        }
        return lista;
    }

    @Override
    public void deletar(ID id) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }
    }

    public T selecionarPorCampo(String coluna, String valor) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " WHERE " + coluna + " = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, valor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return transformarLinhaSQLEmObjeto(rs);
                }
                return null;
            }
        }
    }

    protected abstract String gerarStringDeInsert();

    protected abstract void configurarParametrosDeInsert(PreparedStatement ps, T entity) throws SQLException;

    protected abstract T transformarLinhaSQLEmObjeto(ResultSet rs) throws SQLException;
}
