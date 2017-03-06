package com.management.project.dao.jdbc;

import com.management.project.connection.ConnectionJdbc;
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

    public CustomerDaoImpl(ConnectionJdbc connectionJdbc) {
        super(connectionJdbc.getConnection());
    }

    @Override
    protected Customer prepare(ResultSet resultSet) {
        Customer customer = new Customer();
        try {
            customer.setId(resultSet.getLong("id"));
            customer.setName(resultSet.getString("name"));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return customer;
    }

    @Override
    protected String getTableName() {
        return "customers";
    }
}
