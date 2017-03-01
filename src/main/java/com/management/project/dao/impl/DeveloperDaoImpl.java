package com.management.project.dao.impl;

import com.management.project.connection.ConnectionDB;
import com.management.project.dao.CompanyDao;
import com.management.project.dao.DeveloperDao;
import com.management.project.dao.ProjectDao;
import com.management.project.dao.SkillDao;
import com.management.project.entity.Developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class DeveloperDaoImpl extends ModelDaoImpl<Developer> implements DeveloperDao {

    private final CompanyDao companyDao;

    private final ProjectDao projectDao;

    private final SkillDao skillDao;

    public DeveloperDaoImpl(
            Connection connection, CompanyDao companyDao,
            ProjectDao projectDao, SkillDao skillDao
    ) {
        super(connection);
        this.companyDao = companyDao;
        this.projectDao = projectDao;
        this.skillDao = skillDao;
    }

    public DeveloperDaoImpl(
            ConnectionDB connectionDB, CompanyDao companyDao,
            ProjectDao projectDao, SkillDao skillDao
    ) throws SQLException {
        this(connectionDB.getConnection(), companyDao, projectDao, skillDao);
    }

    @Override
    public void add(Developer developer) throws SQLException {
        saveFields(developer);
        String sql = "INSERT INTO developers (name, salary, company_id, project_id) VALUES(?, ?, ?,?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            prepareStatement(statement, developer);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Developer developer) throws SQLException {
        String sql = "UPDATE developers SET name = ?, salary = ?, company_id= ?, project_id= ? WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getSalary());
            statement.setLong(3, developer.getCompany().getId());
            statement.setLong(4, developer.getProject().getId());
            statement.setLong(5, developer.getId());
            statement.executeUpdate();
        }
        this.skillDao.addDeveloperSkills(developer);
    }

    @Override
    protected Developer prepare(ResultSet resultSet) throws SQLException {
        Developer developer = new Developer();
        developer.setId(resultSet.getLong("id"));
        developer.setName(resultSet.getString("name"));
        developer.setSalary(resultSet.getInt("salary"));
        developer.setCompany(
                this.companyDao.get(
                        resultSet.getLong("company_id")
                )
        );
        developer.setProject(
                this.projectDao.get(
                        resultSet.getLong("project_id")
                )
        );
        developer.setSkills(
                this.skillDao.getDeveloperSkills(developer)
        );
        return developer;
    }

    @Override
    protected String getTableName() {
        return "developers";
    }

    private void saveFields(Developer developer) throws SQLException {
        if (!this.companyDao.exist(developer.getCompany())) {
            this.companyDao.add(developer.getCompany());
        }
        if (!this.projectDao.exist(developer.getProject())) {
            this.projectDao.add(developer.getProject());
        }
    }

    private static void prepareStatement(PreparedStatement statement, Developer developer) throws SQLException {
        statement.setString(1, developer.getName());
        statement.setInt(2, developer.getSalary());
        statement.setLong(3, developer.getCompany().getId());
        statement.setLong(4, developer.getProject().getId());
    }
}
