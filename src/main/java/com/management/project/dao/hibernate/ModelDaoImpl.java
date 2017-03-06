package com.management.project.dao.hibernate;

import com.management.project.dao.ModelDao;
import com.management.project.entity.Model;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public abstract class ModelDaoImpl<T extends Model> implements ModelDao<T> {

    private final EntityManager entityManager;

    public ModelDaoImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public T get(long id) {
        return this.entityManager.find(getEntityClass(), id);
    }

    @Override
    public Collection<T> getAll() {
        CriteriaQuery<T> criteria = this.entityManager.getCriteriaBuilder().createQuery(getEntityClass());
        criteria.select(criteria.from(getEntityClass()));
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public void add(T model) {
        this.entityManager.persist(model);
    }

    @Override
    public void addAll(Collection<T> models) {
        models.forEach(this::add);
    }

    @Override
    public void update(T model) {
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public void remove(T model) {

    }

    @Override
    public boolean exist(T model) {
        return false;
    }

    protected abstract Class<T> getEntityClass();
}
