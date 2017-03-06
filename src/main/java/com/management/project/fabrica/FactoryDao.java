package com.management.project.fabrica;

import com.management.project.connection.ConnectionHibernateImpl;
import com.management.project.connection.ConnectionType;
import com.management.project.dao.*;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class FactoryDao {

    private static CompanyDao companyDao;

    private static CustomerDao customerDao;

    private static DeveloperDao developerDao;

    private static ProjectDao projectDao;

    private static SkillDao skillDao;

    private FactoryDao() {

    }

    public static CompanyDao getCompanyDao(final ConnectionType type) {
        if (companyDao == null) {
            initCompanyDao(type);
        }
        return companyDao;
    }

    public static CustomerDao getCustomerDao(final ConnectionType type) {
        if (customerDao == null) {
            initCustomerDao(type);
        }
        return customerDao;
    }

    public static DeveloperDao getDeveloperDao(final ConnectionType type) {
        if (developerDao == null) {
            initDeveloperDao(type);
        }
        return developerDao;
    }

    public static ProjectDao getProjectDao(final ConnectionType type) {
        if (projectDao == null) {
            initProjectDao(type);
        }
        return projectDao;
    }

    public static SkillDao getSkillDao(final ConnectionType type) {
        if (skillDao == null) {
            initSkillDao(type);
        }
        return skillDao;
    }

    private static void initCompanyDao(final ConnectionType type) {
        switch (type) {
            case JDBC:
                companyDao = new com.management.project.dao.jdbc.CompanyDaoImpl(
                        FactoryConnection.getConnectionJdbcImpl()
                );
                break;
            case HIBERNATE:
                companyDao = new com.management.project.dao.hibernate.CompanyDaoImpl(
                        new ConnectionHibernateImpl().getEntityManager()
                );
                break;
        }
    }

    private static void initCustomerDao(final ConnectionType type) {
        switch (type) {
            case JDBC:
                customerDao = new com.management.project.dao.jdbc.CustomerDaoImpl(
                        FactoryConnection.getConnectionJdbcImpl()
                );
                break;
            case HIBERNATE:
                customerDao = new com.management.project.dao.hibernate.CustomerDaoImpl(
                        new ConnectionHibernateImpl().getEntityManager()
                );
                break;
        }
    }

    private static void initDeveloperDao(final ConnectionType type) {
        switch (type) {
            case JDBC:
                developerDao = new com.management.project.dao.jdbc.DeveloperDaoImpl(
                        FactoryConnection.getConnectionJdbcImpl().getConnection(),
                        getCompanyDao(type),
                        getProjectDao(type),
                        getSkillDao(type)
                );
                break;
            case HIBERNATE:
                developerDao = new com.management.project.dao.hibernate.DeveloperDaoImpl(
                        new ConnectionHibernateImpl().getEntityManager()
                );
                break;
        }
    }

    private static void initProjectDao(final ConnectionType type) {
        switch (type) {
            case JDBC:
                projectDao = new com.management.project.dao.jdbc.ProjectDaoImpl(
                        FactoryConnection.getConnectionJdbcImpl().getConnection(),
                        getCompanyDao(type),
                        getCustomerDao(type)
                );
                break;
            case HIBERNATE:
                projectDao = new com.management.project.dao.hibernate.ProjectDaoImpl(
                        new ConnectionHibernateImpl().getEntityManager()
                );
                break;
        }
    }

    private static void initSkillDao(final ConnectionType type) {
        switch (type) {
            case JDBC:
                skillDao = new com.management.project.dao.jdbc.SkillDaoImpl(
                        FactoryConnection.getConnectionJdbcImpl().getConnection()
                );
                break;
            case HIBERNATE:
                skillDao = new com.management.project.dao.hibernate.SkillDaoImpl(
                        new ConnectionHibernateImpl().getEntityManager()
                );
                break;
        }
    }
}
