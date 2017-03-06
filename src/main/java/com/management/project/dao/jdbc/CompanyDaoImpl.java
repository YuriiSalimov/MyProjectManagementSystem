package com.management.project.dao.jdbc;

import com.management.project.connection.ConnectionJdbc;
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

    public CompanyDaoImpl(ConnectionJdbc connectionJdbc) {
        super(connectionJdbc.getConnection());
    }

    @Override
    protected Company prepare(ResultSet resultSet) {
        Company company = new Company();
        try {
            company.setId(resultSet.getLong("id"));
            company.setName(resultSet.getString("name"));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return company;
    }

    @Override
    protected String getTableName() {
        return "companies";
    }
}
