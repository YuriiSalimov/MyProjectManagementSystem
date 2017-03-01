package com.management.project.controller;

import com.management.project.dao.CompanyDao;
import com.management.project.entity.Company;

import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class CompanyController extends ModelController<Company> {

    private final CompanyDao dao;

    public CompanyController(CompanyDao dao) {
        super(dao);
        this.dao = dao;
    }

    public void startMenu() throws SQLException {
        printMainMenu();
        int menuNumber = inputChoice();
        choiceOfMenu(menuNumber);
    }

    @Override
    protected void printMainMenu() {
        System.out.println("===============");
        System.out.println("COMPANY MENU");
        System.out.println("---------------");
        super.printMainMenu();
    }

    @Override
    protected Company getNewInstance() {
        return new Company();
    }
}
