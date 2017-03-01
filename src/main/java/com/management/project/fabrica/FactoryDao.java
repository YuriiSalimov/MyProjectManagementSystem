package com.management.project.fabrica;

import com.management.project.connection.ConnectionDB;
import com.management.project.connection.ConnectionJdbs;
import com.management.project.dao.*;
import com.management.project.dao.impl.*;

import java.sql.SQLException;

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

    public static CompanyDao getCompanyDao() throws SQLException {
        if (companyDao == null) {
            initCompanyDao();
        }
        return companyDao;
    }

    public static CustomerDao getCustomerDao() throws SQLException {
        if (customerDao == null) {
            initCustomerDao();
        }
        return customerDao;
    }

    public static DeveloperDao getDeveloperDao() throws SQLException {
        if (developerDao == null) {
            initDeveloperDao();
        }
        return developerDao;
    }

    public static ProjectDao getProjectDao() throws SQLException {
        if (projectDao == null) {
            initProjectDao();
        }
        return projectDao;
    }

    public static SkillDao getSkillDao() throws SQLException {
        if (skillDao == null) {
            initSkillDao();
        }
        return skillDao;
    }

    private static void initCompanyDao() throws SQLException {
        companyDao = new CompanyDaoImpl(FactoryConnection.getConnectionJdbs());
    }

    private static void initCustomerDao() throws SQLException {
        customerDao = new CustomerDaoImpl(FactoryConnection.getConnectionJdbs());
    }

    private static void initDeveloperDao() throws SQLException {
        developerDao = new DeveloperDaoImpl(
                FactoryConnection.getConnectionJdbs(),
                getCompanyDao(),
                getProjectDao(),
                getSkillDao()
        );
    }

    private static void initProjectDao() throws SQLException {
        projectDao = new ProjectDaoImpl(
                FactoryConnection.getConnectionJdbs(),
                getCompanyDao(),
                getCustomerDao()
        );
    }

    private static void initSkillDao() throws SQLException {
        skillDao = new SkillDaoImpl(FactoryConnection.getConnectionJdbs());
    }
}
