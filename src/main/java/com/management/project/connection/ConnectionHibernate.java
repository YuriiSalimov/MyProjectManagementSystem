package com.management.project.connection;

import javax.persistence.EntityManager;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface ConnectionHibernate {

    EntityManager getEntityManager();

    void closeEntityManagerFactory();
}
