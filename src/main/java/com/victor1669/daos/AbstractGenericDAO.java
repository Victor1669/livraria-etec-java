package com.victor1669.daos;

import com.victor1669.interfaces.IGenericDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGenericDAO<T, ID> implements IGenericDAO<T, ID> {

    protected final Connection conn;
    protected final String tableName;

    public AbstractGenericDAO(Connection conn, String tableName) {
        this.conn = conn;
        this.tableName = tableName;
    }

    // ===================== TEMPLATE METHODS =====================
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
                T entity = transformarLinhaSQLEmObjeto(rs);
                lista.add(entity);
            }
        }
        return lista;
    }

    @Override
    public T selecionarIndividual(String WHERE) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " " + WHERE;

        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            T entity = transformarLinhaSQLEmObjeto(rs);

            return entity;
        }
    }

    // ===================== MÉTODOS ABSTRATOS =====================
    protected abstract String gerarStringDeInsert();

    protected abstract void configurarParametrosDeInsert(PreparedStatement ps, T entity) throws SQLException;

    protected abstract T transformarLinhaSQLEmObjeto(ResultSet rs) throws SQLException;
}
