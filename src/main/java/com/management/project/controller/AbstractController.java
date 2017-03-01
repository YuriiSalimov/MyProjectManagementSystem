package com.management.project.controller;

import com.management.project.dao.ModelDao;
import com.management.project.entity.Developer;
import com.management.project.entity.Model;
import com.management.project.entity.Skill;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public abstract class AbstractController {

    protected static final Scanner SCANNER = new Scanner(System.in);

    public void startMenu() throws SQLException {
        while (true) {
            printMainMenu();
            int menuNumber = inputChoice();
            if (menuNumber == 0) {
                break;
            }
            choiceOfMenu(menuNumber);
        }
    }

    protected static int inputChoice() {
        System.out.print("Input: ");
        int result;
        try {
            result = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException ex) {
            result = -1;
        }
        return result;
    }

    protected abstract void printMainMenu();

    protected abstract void choiceOfMenu(int menuNumber) throws SQLException;
}
