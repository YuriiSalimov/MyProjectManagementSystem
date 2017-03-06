package com.management.project;

import com.management.project.connection.ConnectionType;
import com.management.project.controller.MainController;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        try {
            new MainController(ConnectionType.HIBERNATE).startMenu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
