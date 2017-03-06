package com.management.project.fabrica;

import com.management.project.connection.ConnectionType;
import com.management.project.controller.*;

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

    public static CompanyController getCompanyController(final ConnectionType type) {
        if (companyController == null) {
            initCompanyController(type);
        }
        return companyController;
    }

    public static CustomerController getCustomerController(final ConnectionType type)  {
        if (customerController == null) {
            initCustomerController(type);
        }
        return customerController;
    }

    public static DeveloperController getDeveloperController(final ConnectionType type) {
        if (developerController == null) {
            initDeveloperController(type);
        }
        return developerController;
    }

    public static ProjectController getProjectController(final ConnectionType type)  {
        if (projectController == null) {
            initProjectController(type);
        }
        return projectController;
    }

    public static SkillController getSkillController(final ConnectionType type)  {
        if (skillController == null) {
            initSkillController(type);
        }
        return skillController;
    }

    private static void initCompanyController(final ConnectionType type)  {
        companyController = new CompanyController(FactoryDao.getCompanyDao(type));
    }

    private static void initCustomerController(final ConnectionType type)  {
        customerController = new CustomerController(FactoryDao.getCustomerDao(type));
    }

    private static void initDeveloperController(final ConnectionType type)  {
        developerController = new DeveloperController(
                FactoryDao.getDeveloperDao(type),
                FactoryDao.getCompanyDao(type),
                FactoryDao.getProjectDao(type),
                FactoryDao.getSkillDao(type)
        );
    }

    private static void initProjectController(final ConnectionType type)  {
        projectController = new ProjectController(
                FactoryDao.getProjectDao(type),
                FactoryDao.getCompanyDao(type),
                FactoryDao.getCustomerDao(type)
        );
    }

    private static void initSkillController(final ConnectionType type)  {
        skillController = new SkillController(FactoryDao.getSkillDao(type));
    }
}
