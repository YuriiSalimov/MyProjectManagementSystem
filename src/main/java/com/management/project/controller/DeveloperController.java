package com.management.project.controller;

import com.management.project.dao.CompanyDao;
import com.management.project.dao.DeveloperDao;
import com.management.project.dao.ProjectDao;
import com.management.project.dao.SkillDao;
import com.management.project.entity.*;

import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class DeveloperController extends ModelController<Developer> {

    private final DeveloperDao developerDao;

    private final CompanyDao companyDao;

    private final ProjectDao projectDao;

    private final SkillDao skillDao;

    public DeveloperController(
            DeveloperDao developerDao, CompanyDao companyDao,
            ProjectDao projectDao, SkillDao skillDao
    ) {
        super(developerDao);
        this.developerDao = developerDao;
        this.companyDao = companyDao;
        this.projectDao = projectDao;
        this.skillDao = skillDao;
    }

    @Override
    protected void printMainMenu() {
        System.out.println("===============");
        System.out.println("DEVELOPER MENU");
        System.out.println("---------------");
        super.printMainMenu();
    }

    @Override
    protected void getAllAndPrint() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("GET ALL DEVELOPERS");
        System.out.println("---------------");
        super.getAllAndPrint();
    }

    @Override
    protected void getByIdAndPrint() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("GET DEVELOPER BY ID");
        System.out.println("---------------");
        super.getByIdAndPrint();
    }

    @Override
    protected void addNew() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("ADD NEW DEVELOPER");
        System.out.println("---------------");
        this.developerDao.add(prepareDeveloper(true));
    }

    @Override
    protected void updateById() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("UPDATE DEVELOPER");
        System.out.println("---------------");
        System.out.print("Input developer id: ");
        long id = SCANNER.nextLong();
        SCANNER.nextLine();
        Developer developer = prepareDeveloper(false);
        developer.setId(id);
        this.developerDao.update(developer);
    }

    @Override
    protected void removeById() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("REMOVE DEVELOPER");
        System.out.println("---------------");
        super.removeById();
    }

    @Override
    protected Developer getNewInstance() {
        return new Developer();
    }

    private Developer prepareDeveloper(boolean isNew) throws SQLException {
        Developer developer = new Developer();
        System.out.print("Input developer name: ");
        developer.setName(SCANNER.nextLine());
        System.out.print("Input developer salary: ");
        developer.setSalary(SCANNER.nextInt());
        SCANNER.nextLine();
        if (!isNew) {
            System.out.print("Input skill ids (example, 1,2,3...): ");
            String skillIds = SCANNER.nextLine().replaceAll(" ", "");
            for (String skillId : skillIds.split(",")) {
                Skill skill = this.skillDao.get(Long.parseLong(skillId));
                developer.addSkill(skill);
            }
        }
        System.out.print("Input company id: ");
        long companyId = SCANNER.nextLong();
        developer.setCompany(this.companyDao.get(companyId));
        System.out.print("Input project id: ");
        long projectId = SCANNER.nextLong();
        developer.setProject(this.projectDao.get(projectId));
        SCANNER.nextLine();
        return developer;
    }
}
