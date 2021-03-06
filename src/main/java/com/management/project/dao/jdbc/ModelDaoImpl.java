package com.management.project.dao.jdbc;

import com.management.project.connection.ConnectionJdbc;
import com.management.project.dao.ModelDao;
import com.management.project.entity.Model;

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

    public ModelDaoImpl(ConnectionJdbc connectionJdbc) {
        this(connectionJdbc.getConnection());
    }

    @Override
    public void addAll(Collection<T> models) {
        for (T model : models) {
            add(model);
        }
    }

    @Override
    public void remove(T model) {
        remove(model.getId());
    }

    @Override
    public T get(long id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        T model = null;
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                model = prepare(resultSet);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return model;
    }

    @Override
    public Collection<T> getAll() {
        String sql = "SELECT * FROM " + getTableName();
        List<T> models = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                models.add(prepare(resultSet));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return models;
    }

    @Override
    public void add(T model) {
        String sql = "INSERT INTO " + getTableName() + " (name) VALUES (?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, model.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(T model) {
        String sql = "UPDATE " + getTableName() + " SET name = ? WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, model.getName());
            statement.setLong(2, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void remove(long id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean exist(T model) {
        String sql = "SELECT EXISTS (SELECT * FROM " + getTableName() + " WHERE id = ?)";
        boolean result;
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setLong(1, model.getId());
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next() && resultSet.getBoolean(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    protected abstract T prepare(ResultSet resultSet) throws SQLException;

    protected abstract String getTableName();
}
