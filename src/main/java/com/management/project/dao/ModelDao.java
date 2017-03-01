package com.management.project.dao;

import com.management.project.entity.Model;

import java.sql.SQLException;
import java.util.Collection;

/**
 * @param <T> Entity type, extends {@link Model}.
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface ModelDao<T extends Model> {

    T get(long id) throws SQLException;

    Collection<T> getAll() throws SQLException;

    void add(T model) throws SQLException;

    void addAll(Collection<T> models) throws SQLException;

    void update(T model) throws SQLException;

    void remove(long id) throws SQLException;

    void remove(T model) throws SQLException;

    boolean exist(T model) throws SQLException;
}
