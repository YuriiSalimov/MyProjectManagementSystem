package com.management.project.dao.hibernate;

import com.management.project.dao.DeveloperDao;
import com.management.project.entity.Developer;

import javax.persistence.EntityManager;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class DeveloperDaoImpl extends ModelDaoImpl<Developer> implements DeveloperDao {

    public DeveloperDaoImpl(final EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Developer> getEntityClass() {
        return Developer.class;
    }
}
