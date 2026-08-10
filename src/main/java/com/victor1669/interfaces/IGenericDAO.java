package com.victor1669.interfaces;

import com.victor1669.services.UpdateParam;
import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T, ID> {

    void insert(T entity) throws SQLException;

    List<T> selectAll() throws SQLException;

    void delete(ID id) throws SQLException;

    void update(int id, UpdateParam... up) throws SQLException;
}
