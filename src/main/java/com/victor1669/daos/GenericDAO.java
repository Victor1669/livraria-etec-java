package com.victor1669.daos;

import com.victor1669.interfaces.IGenericDAO;
import com.victor1669.services.UpdateParam;
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
    public void insert(T entity) throws SQLException {
        String sql = buildInsertQuery();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            setInsertParameters(ps, entity);
            ps.executeUpdate();
        }
    }

    @Override
    public List<T> selectAll() throws SQLException {
        String sql = "SELECT * FROM " + tableName;
        List<T> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapRowToEntity(rs));
            }
        }
        return list;
    }

    @Override
    public void delete(ID id) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(int id, UpdateParam[] params) throws SQLException {
        if (params.length == 0) {
            return;
        }
        StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
        for (int i = 0; i < params.length; i++) {
            UpdateParam param = params[i];
            boolean isLastParam = i == params.length - 1;
            sql.append(param.column).append(" = ?").append(isLastParam ? " " : ", ");
        }
        sql.append("WHERE id = ?");

        try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            int i;
            for (i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i].value);
            }
            ps.setInt(i + 1, id);
            ps.executeUpdate();
        }
    }

    public T selectByField(String column, String value) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " WHERE " + column + " = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, value);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToEntity(rs);
                }
                return null;
            }
        }
    }

    public List<T> selectAllByField(String column, String value) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " WHERE " + column + " = ?";
        List<T> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, value);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToEntity(rs));
                }
            }
        }
        return list;
    }

    protected abstract String buildInsertQuery();

    protected abstract void setInsertParameters(PreparedStatement ps, T entity) throws SQLException;

    protected abstract T mapRowToEntity(ResultSet rs) throws SQLException;
}
