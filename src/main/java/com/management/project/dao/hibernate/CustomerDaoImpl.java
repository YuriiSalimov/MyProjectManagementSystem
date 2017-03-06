package com.management.project.dao.hibernate;

import com.management.project.dao.CompanyDao;
import com.management.project.dao.CustomerDao;
import com.management.project.entity.Customer;

import javax.persistence.EntityManager;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class CustomerDaoImpl extends ModelDaoImpl<Customer> implements CustomerDao {

    public CustomerDaoImpl(final EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
