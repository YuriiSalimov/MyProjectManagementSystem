package com.management.project.controller;

import com.management.project.dao.ModelDao;
import com.management.project.entity.Model;

import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public abstract class ModelController<T extends Model> extends AbstractController {

    private final ModelDao<T> dao;

    public ModelController(ModelDao<T> dao) {
        this.dao = dao;
    }

    @Override
    protected void printMainMenu() {
        System.out.println("1 - get all");
        System.out.println("2 - get by id");
        System.out.println("3 - add");
        System.out.println("4 - update");
        System.out.println("5 - remove");
        System.out.println("0 - in main menu");
    }

    @Override
    protected void choiceOfMenu(int menuNumber) throws SQLException {
        switch (menuNumber) {
            case 1:
                getAllAndPrint();
                break;
            case 2:
                getByIdAndPrint();
                break;
            case 3:
                addNew();
                break;
            case 4:
                updateById();
                break;
            case 5:
                removeById();
                break;
        }
    }

    protected void getAllAndPrint() throws SQLException {
        this.dao.getAll().forEach(System.out::println);
    }

    protected void getByIdAndPrint() throws SQLException {
        System.out.print("Input id: ");
        long id = SCANNER.nextLong();
        System.out.println(this.dao.get(id));
        SCANNER.nextLine();
    }

    protected void addNew() throws SQLException {
        System.out.print("Input name: ");
        String name = SCANNER.nextLine();
        T model = getNewInstance();
        model.setName(name);
        this.dao.add(model);
    }

    protected void updateById() throws SQLException {
        System.out.print("Input id: ");
        long id = SCANNER.nextLong();
        SCANNER.nextLine();
        System.out.print("Input a new name: ");
        String name = SCANNER.nextLine();
        T model = getNewInstance();
        model.setName(name);
        model.setId(id);
        this.dao.update(model);
    }

    protected void removeById() throws SQLException {
        System.out.print("Input id: ");
        long id = SCANNER.nextLong();
        this.dao.remove(id);
        SCANNER.nextLine();
    }

    protected abstract T getNewInstance();
}
