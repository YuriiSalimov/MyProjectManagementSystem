package com.management.project.controller;

import com.management.project.dao.SkillDao;
import com.management.project.entity.Skill;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class SkillController extends ModelController<Skill> {

    public SkillController(SkillDao dao) {
        super(dao);
    }

    @Override
    protected void printMainMenu() {
        System.out.println("===============");
        System.out.println("SKILL MENU");
        System.out.println("---------------");
        super.printMainMenu();
    }

    @Override
    protected void getAllAndPrint() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("GET ALL SKILLS");
        System.out.println("---------------");
        super.getAllAndPrint();
    }

    @Override
    protected void getByIdAndPrint() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("GET SKILL BY ID");
        System.out.println("---------------");
        super.getByIdAndPrint();
    }

    @Override
    protected void addNew() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("ADD NEW SKILL");
        System.out.println("---------------");
        super.addNew();
    }

    @Override
    protected void updateById() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("UPDATE SKILL");
        System.out.println("---------------");
        super.updateById();
    }

    @Override
    protected void removeById() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("REMOVE SKILL");
        System.out.println("---------------");
        super.removeById();
    }

    @Override
    protected Skill getNewInstance() {
        return new Skill();
    }
}
