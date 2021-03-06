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

    T get(long id);

    Collection<T> getAll();

    void add(T model);

    void addAll(Collection<T> models);

    void update(T model);

    void remove(long id);

    void remove(T model);

    boolean exist(T model);
}
