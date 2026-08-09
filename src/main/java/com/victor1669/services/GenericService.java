package com.victor1669.services;

import com.victor1669.daos.GenericDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericService<T, ID> {

    protected abstract GenericDAO<T, ID> getDao() throws SQLException;

    public abstract ValidationResult create(T model) throws SQLException;

    public List<T> getAll() throws SQLException {
        List<T> lista = getDao().selectAll();
        return lista != null ? lista : new ArrayList<>();
    }

    public void delete(ID itemId) throws SQLException {
        getDao().delete(itemId);
    }
    
    public T getByField(String field, String value) throws SQLException {
        T lista = getDao().selectByField(field, value);
        return lista;
    }

    public List<T> getAllByField(String field, String value) throws SQLException {
        List<T> lista = getDao().selectAllByField(field, value);
        return lista != null ? lista : new ArrayList<>();
    }
}
