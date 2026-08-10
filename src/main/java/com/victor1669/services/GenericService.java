package com.victor1669.services;

import com.victor1669.conexoes.ConexaoJPA;
import java.util.List;

public abstract class GenericService<T, ID> {

    private final Class<T> entityClass;

    protected GenericService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        ConexaoJPA.getInstancia().executeInTransaction(em -> em.persist(entity));
    }

    public T getById(ID id) {
        return ConexaoJPA.getInstancia().execute(em -> em.find(entityClass, id));
    }

    public List<T> listarTodos() {
        return ConexaoJPA.getInstancia().execute(em
                -> em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                        .getResultList()
        );
    }

    public void update(T entity) {
        ConexaoJPA.getInstancia().executeInTransaction(em -> em.merge(entity));
    }

    public void delete(ID id) {
        ConexaoJPA.getInstancia().executeInTransaction(em -> {
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
            }
        });
    }
}
