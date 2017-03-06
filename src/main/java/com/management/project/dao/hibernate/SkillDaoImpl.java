package com.management.project.dao.hibernate;

import com.management.project.dao.SkillDao;
import com.management.project.entity.Developer;
import com.management.project.entity.Skill;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public class SkillDaoImpl extends ModelDaoImpl<Skill> implements SkillDao {

    public SkillDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void addDeveloperSkills(Developer developer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Skill> getDeveloperSkills(Developer developer) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Class<Skill> getEntityClass() {
        return Skill.class;
    }
}
