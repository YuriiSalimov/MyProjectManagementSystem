package com.management.project.controller;

import com.management.project.dao.CustomerDao;
import com.management.project.entity.Customer;

import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class CustomerController extends ModelController<Customer> {

    public CustomerController(CustomerDao dao) {
        super(dao);
    }

    @Override
    protected void printMainMenu() {
        System.out.println("===============");
        System.out.println("CUSTOMER MENU");
        System.out.println("---------------");
        super.printMainMenu();
    }

    @Override
    protected void getAllAndPrint() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("GET ALL CUSTOMERS");
        System.out.println("---------------");
        super.getAllAndPrint();
    }

    @Override
    protected void getByIdAndPrint() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("GET CUSTOMER BY ID");
        System.out.println("---------------");
        super.getByIdAndPrint();
    }

    @Override
    protected void addNew() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("ADD NEW CUSTOMER");
        System.out.println("---------------");
        super.addNew();
    }

    @Override
    protected void updateById() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("UPDATE CUSTOMER");
        System.out.println("---------------");
        super.updateById();
    }

    @Override
    protected void removeById() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("REMOVE CUSTOMER");
        System.out.println("---------------");
        super.removeById();
    }

    @Override
    protected Customer getNewInstance() {
        return new Customer();
    }
}
