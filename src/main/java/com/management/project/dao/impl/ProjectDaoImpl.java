package com.management.project.dao.impl;

import com.management.project.connection.ConnectionDB;
import com.management.project.dao.CompanyDao;
import com.management.project.dao.CustomerDao;
import com.management.project.dao.ProjectDao;
import com.management.project.entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class ProjectDaoImpl extends ModelDaoImpl<Project> implements ProjectDao {

    private final CompanyDao companyDao;

    private final CustomerDao customerDao;

    public ProjectDaoImpl(
            Connection connection,
            CompanyDao companyDao,
            CustomerDao customerDao
    ) {
        super(connection);
        this.companyDao = companyDao;
        this.customerDao = customerDao;
    }

    public ProjectDaoImpl(
            ConnectionDB connectionDB,
            CompanyDao companyDao,
            CustomerDao customerDao
    ) throws SQLException {
        this(connectionDB.getConnection(), companyDao, customerDao);
    }

    @Override
    public void add(Project project) throws SQLException {
        saveFields(project);
        String sql = "INSERT INTO projects (name, cost, company_id, customer_id) VALUES(?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            prepareStatement(statement, project);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Project project) throws SQLException {
        String sql = "UPDATE projects SET name = ?, cost = ?, company_id = ?, customer_id = ? WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            prepareStatement(statement, project);
            statement.setLong(5, project.getId());
            statement.executeUpdate();
        }
    }

    @Override
    protected Project prepare(ResultSet resultSet) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getLong("id"));
        project.setName(resultSet.getString("name"));
        project.setCost(resultSet.getInt("cost"));
        project.setCompany(
                this.companyDao.get(
                        resultSet.getLong("company_id")
                )
        );
        project.setCustomer(
                this.customerDao.get(
                        resultSet.getLong("customer_id")
                )
        );
        return project;
    }

    @Override
    protected String getTableName() {
        return "projects";
    }

    private void saveFields(Project project) throws SQLException {
        if (!this.companyDao.exist(project.getCompany())) {
            this.companyDao.add(project.getCompany());
        }
        if (!this.customerDao.exist(project.getCustomer())) {
            this.customerDao.add(project.getCustomer());
        }
    }

    private static void prepareStatement(PreparedStatement statement, Project project) throws SQLException {
        statement.setString(1, project.getName());
        statement.setInt(2, project.getCost());
        statement.setLong(3, project.getCompany().getId());
        statement.setLong(4, project.getCustomer().getId());
    }
}
