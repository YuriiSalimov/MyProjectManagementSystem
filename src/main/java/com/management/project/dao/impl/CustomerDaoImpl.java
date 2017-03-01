package com.management.project.dao.impl;

import com.management.project.connection.ConnectionDB;
import com.management.project.dao.CustomerDao;
import com.management.project.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class CustomerDaoImpl extends ModelDaoImpl<Customer> implements CustomerDao {

    public CustomerDaoImpl(Connection connection) {
        super(connection);
    }

    public CustomerDaoImpl(ConnectionDB connectionDB) throws SQLException {
        super(connectionDB.getConnection());
    }

    @Override
    protected Customer prepare(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getLong("id"));
        customer.setName(resultSet.getString("name"));
        return customer;
    }

    @Override
    protected String getTableName() {
        return "customers";
    }
}
