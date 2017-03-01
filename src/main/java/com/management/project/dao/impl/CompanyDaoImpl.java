package com.management.project.dao.impl;

import com.management.project.connection.ConnectionDB;
import com.management.project.dao.CompanyDao;
import com.management.project.entity.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class CompanyDaoImpl extends ModelDaoImpl<Company> implements CompanyDao {

    public CompanyDaoImpl(Connection connection) {
        super(connection);
    }

    public CompanyDaoImpl(ConnectionDB connectionDB) throws SQLException {
        super(connectionDB.getConnection());
    }

    @Override
    protected Company prepare(ResultSet resultSet) throws SQLException {
        Company company = new Company();
        company.setId(resultSet.getLong("id"));
        company.setName(resultSet.getString("name"));
        return company;
    }

    @Override
    protected String getTableName() {
        return "companies";
    }
}
