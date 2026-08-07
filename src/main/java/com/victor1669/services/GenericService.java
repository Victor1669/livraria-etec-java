package com.victor1669.services;

import java.sql.SQLException;
import java.util.List;

public abstract class GenericService<T> {

    public Runnable onSuccess;
    public Runnable onInvalid;

    public abstract void criar(T model) throws SQLException;

    public abstract List<T> getItems() throws SQLException;

    public abstract void deleteItem(int itemId) throws SQLException;
}
