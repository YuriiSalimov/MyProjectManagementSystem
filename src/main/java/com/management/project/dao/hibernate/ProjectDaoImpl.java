package com.management.project.dao.hibernate;

import com.management.project.dao.ProjectDao;
import com.management.project.entity.Project;

import javax.persistence.EntityManager;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class ProjectDaoImpl extends ModelDaoImpl<Project> implements ProjectDao {

    public ProjectDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Project> getEntityClass() {
        return Project.class;
    }
}
