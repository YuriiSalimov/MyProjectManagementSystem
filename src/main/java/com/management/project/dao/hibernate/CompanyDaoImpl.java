package com.management.project.dao.hibernate;

import com.management.project.dao.CompanyDao;
import com.management.project.entity.Company;

import javax.persistence.EntityManager;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class CompanyDaoImpl extends ModelDaoImpl<Company> implements CompanyDao {

    public CompanyDaoImpl(final EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Company> getEntityClass() {
        return Company.class;
    }
}
