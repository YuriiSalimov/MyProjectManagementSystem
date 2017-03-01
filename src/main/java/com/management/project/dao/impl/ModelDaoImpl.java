package com.management.project.dao.impl;

import com.management.project.connection.ConnectionDB;
import com.management.project.dao.ModelDao;
import com.management.project.entity.Company;
import com.management.project.entity.Model;
import com.management.project.entity.Skill;

import java.sql.*;
import java.util.*;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public abstract class ModelDaoImpl<T extends Model> implements ModelDao<T> {

    protected final Connection connection;

    public ModelDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public ModelDaoImpl(ConnectionDB connectionDB) throws SQLException {
        this(connectionDB.getConnection());
    }

    @Override
    public void addAll(Collection<T> models) throws SQLException {
        for (T model : models) {
            add(model);
        }
    }

    @Override
    public void remove(T model) throws SQLException {
        remove(model.getId());
    }

    @Override
    public T get(long id) throws SQLException {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        T model = null;
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                model = prepare(resultSet);
            }
        }
        return model;
    }

    @Override
    public Collection<T> getAll() throws SQLException {
        String sql = "SELECT * FROM " + getTableName();
        List<T> models = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                models.add(prepare(resultSet));
            }
        }
        return models;
    }

    @Override
    public void add(T model) throws SQLException {
        String sql = "INSERT INTO " + getTableName() + " (name) VALUES (?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, model.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(T model) throws SQLException {
        String sql = "UPDATE " + getTableName() + " SET name = ? WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, model.getName());
            statement.setLong(2, model.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void remove(long id) throws SQLException {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean exist(T model) throws SQLException {
        String sql = "SELECT EXISTS (SELECT * FROM " + getTableName() + " WHERE id = ?)";
        boolean result;
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setLong(1, model.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getBoolean(1);
            } else {
                result = false;
            }
        }
        return result;
    }

    protected abstract T prepare(ResultSet resultSet) throws SQLException;

    protected abstract String getTableName();
}
