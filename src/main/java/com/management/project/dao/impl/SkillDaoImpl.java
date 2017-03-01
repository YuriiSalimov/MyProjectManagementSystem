package com.management.project.dao.impl;

import com.management.project.connection.ConnectionDB;
import com.management.project.dao.SkillDao;
import com.management.project.entity.Developer;
import com.management.project.entity.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class SkillDaoImpl extends ModelDaoImpl<Skill> implements SkillDao {

    public SkillDaoImpl(Connection connection) {
        super(connection);
    }

    public SkillDaoImpl(ConnectionDB connectionDB) throws SQLException {
        super(connectionDB.getConnection());
    }

    @Override
    public void addDeveloperSkills(Developer developer) throws SQLException {
        String sql = "INSERT INTO developers_skills (developer_id, skill_id) VALUES(?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            for (Skill skill : developer.getSkills()) {
                statement.setLong(1, developer.getId());
                statement.setLong(2, skill.getId());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public Collection<Skill> getDeveloperSkills(Developer developer) throws SQLException {
        String sql = "SELECT * FROM developers_skills WHERE developer_id = ?";
        List<Skill> models = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setLong(1, developer.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                models.add(this.get(resultSet.getLong("skill_id")));
            }
        }
        return models;
    }

    @Override
    protected Skill prepare(ResultSet resultSet) throws SQLException {
        Skill skill = new Skill();
        skill.setId(resultSet.getLong("id"));
        skill.setName(resultSet.getString("name"));
        return skill;
    }

    @Override
    protected String getTableName() {
        return "skills";
    }
}
