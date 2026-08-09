package com.victor1669.services;

import java.sql.SQLException;
import java.util.List;

public abstract class GenericService<T> {

    public abstract ValidationResult create(T model) throws SQLException;

    public abstract List<T> getAll() throws SQLException;

    public abstract void delete(int itemId) throws SQLException;

    public abstract T getByField(String field, String value) throws SQLException;
}
