package com.management.project.controller;

import com.management.project.connection.ConnectionType;
import com.management.project.fabrica.FactoryConnection;
import com.management.project.fabrica.FactoryController;

import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class MainController extends AbstractController {

    private final CompanyController companyController;

    private final CustomerController customerController;

    private final DeveloperController developerController;

    private final ProjectController projectController;

    private final SkillController skillController;

    public MainController(final ConnectionType type) throws SQLException {
        this.companyController = FactoryController.getCompanyController(type);
        this.customerController = FactoryController.getCustomerController(type);
        this.developerController = FactoryController.getDeveloperController(type);
        this.projectController = FactoryController.getProjectController(type);
        this.skillController = FactoryController.getSkillController(type);
    }

    @Override
    protected void choiceOfMenu(int menuNumber) throws SQLException {
        switch (menuNumber) {
            case 1:
                this.companyController.startMenu();
                break;
            case 2:
                this.customerController.startMenu();
                break;
            case 3:
                this.developerController.startMenu();
                break;
            case 4:
                this.projectController.startMenu();
                break;
            case 5:
                this.skillController.startMenu();
                break;
            default:
                FactoryConnection.getConnectionJdbcImpl().close();
                System.exit(0);
        }
    }

    @Override
    protected void printMainMenu() {
        System.out.println("===============");
        System.out.println("MAIN MENU");
        System.out.println("---------------");
        System.out.println("1 - company menu");
        System.out.println("2 - customer menu");
        System.out.println("3 - developer menu");
        System.out.println("4 - project menu");
        System.out.println("5 - skill menu");
        System.out.println("0 - exit");
    }
}
