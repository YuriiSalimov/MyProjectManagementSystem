package com.management.project.fabrica;

import com.management.project.controller.*;

import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class FactoryController {

    private static CompanyController companyController;

    private static CustomerController customerController;

    private static DeveloperController developerController;

    private static ProjectController projectController;

    private static SkillController skillController;

    private FactoryController() {

    }

    public static CompanyController getCompanyController() throws SQLException {
        if (companyController == null) {
            initCompanyController();
        }
        return companyController;
    }

    public static CustomerController getCustomerController() throws SQLException {
        if (customerController == null) {
            initCustomerController();
        }
        return customerController;
    }

    public static DeveloperController getDeveloperController() throws SQLException {
        if (developerController == null) {
            initDeveloperController();
        }
        return developerController;
    }

    public static ProjectController getProjectController() throws SQLException {
        if (projectController == null) {
            initProjectController();
        }
        return projectController;
    }

    public static SkillController getSkillController() throws SQLException {
        if (skillController == null) {
            initSkillController();
        }
        return skillController;
    }

    private static void initCompanyController() throws SQLException {
        companyController = new CompanyController(FactoryDao.getCompanyDao());
    }

    private static void initCustomerController() throws SQLException {
        customerController = new CustomerController(FactoryDao.getCustomerDao());
    }

    private static void initDeveloperController() throws SQLException {
        developerController = new DeveloperController(
                FactoryDao.getDeveloperDao(),
                FactoryDao.getCompanyDao(),
                FactoryDao.getProjectDao(),
                FactoryDao.getSkillDao()
        );
    }

    private static void initProjectController() throws SQLException {
        projectController = new ProjectController(
                FactoryDao.getProjectDao(),
                FactoryDao.getCompanyDao(),
                FactoryDao.getCustomerDao()
        );
    }

    private static void initSkillController() throws SQLException {
        skillController = new SkillController(FactoryDao.getSkillDao());
    }
}
