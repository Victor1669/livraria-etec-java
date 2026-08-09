package com.victor1669.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T, ID> {

    void insert(T entity) throws SQLException;

    List<T> selectAll() throws SQLException;

    void delete(ID id) throws SQLException;

}
