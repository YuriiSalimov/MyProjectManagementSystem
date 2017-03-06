package com.management.project.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class ConnectionHibernateImpl implements ConnectionHibernate {

    private static EntityManagerFactory entityManagerFactory;

    @Override
    public EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            initEntityManagerFactory();
        }
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    private static void initEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("HibernatePersistenceUnit");
    }
}
