package com.management.project.controller;

import com.management.project.dao.CompanyDao;
import com.management.project.dao.CustomerDao;
import com.management.project.dao.ProjectDao;
import com.management.project.entity.Company;
import com.management.project.entity.Customer;
import com.management.project.entity.Project;

import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class ProjectController extends ModelController<Project> {

    private final ProjectDao projectDao;

    private final CompanyDao companyDao;

    private final CustomerDao customerDao;

    public ProjectController(ProjectDao projectDao, CompanyDao companyDao, CustomerDao customerDao) {
        super(projectDao);
        this.projectDao = projectDao;
        this.companyDao = companyDao;
        this.customerDao = customerDao;
    }

    @Override
    protected void printMainMenu() {
        System.out.println("===============");
        System.out.println("PROJECT MENU");
        System.out.println("---------------");
        super.printMainMenu();
    }

    @Override
    protected void getAllAndPrint() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("GET ALL PROJECTS");
        System.out.println("---------------");
        super.getAllAndPrint();
    }

    @Override
    protected void getByIdAndPrint() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("GET PROJECT BY ID");
        System.out.println("---------------");
        super.getByIdAndPrint();
    }

    @Override
    protected void addNew() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("ADD NEW PROJECT");
        System.out.println("---------------");
        this.projectDao.add(prepareProject());
    }

    @Override
    protected void updateById() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("UPDATE PROJECT");
        System.out.println("---------------");
        System.out.print("Input project id: ");
        long id = SCANNER.nextLong();
        Project project = prepareProject();
        project.setId(id);
        this.projectDao.update(project);
    }

    @Override
    protected void removeById() throws SQLException {
        System.out.println("^^^^^^^^^^^^^^^");
        System.out.println("REMOVE PROJECT");
        System.out.println("---------------");
        super.removeById();
    }

    @Override
    protected Project getNewInstance() {
        return new Project();
    }

    private Project prepareProject() throws SQLException {
        SCANNER.nextLine();
        System.out.print("Input project name: ");
        String projectName = SCANNER.nextLine();
        System.out.print("Input project cost: ");
        int projectCost = SCANNER.nextInt();
        System.out.print("Input company id: ");
        long companyId = SCANNER.nextLong();
        System.out.print("Input customer id: ");
        long customerId = SCANNER.nextLong();
        Company company = this.companyDao.get(companyId);
        Customer customer = this.customerDao.get(customerId);
        return new Project(projectName, projectCost, company, customer);
    }
}
