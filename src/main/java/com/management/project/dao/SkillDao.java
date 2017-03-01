package com.management.project.dao;

import com.management.project.entity.Developer;
import com.management.project.entity.Skill;

import java.sql.SQLException;
import java.util.Collection;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface SkillDao extends ModelDao<Skill> {

    void addDeveloperSkills(Developer developer) throws SQLException;

    Collection<Skill> getDeveloperSkills(Developer developer) throws SQLException;
}

