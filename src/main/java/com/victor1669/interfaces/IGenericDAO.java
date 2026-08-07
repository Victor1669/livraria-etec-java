package com.victor1669.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T, ID> {

    void inserir(T entity) throws SQLException;

    List<T> selecionarTodos() throws SQLException;

}
