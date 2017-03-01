package com.management.project.fabrica;

import com.management.project.connection.ConnectionDB;
import com.management.project.connection.ConnectionJdbs;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class FactoryConnection {

    private final static String DEFAULT_DATABASE_NAME = "projectManagementDB";

    private final static String DEFAULT_USERNAME = "root";

    private final static String DEFAULT_PASSWORD = "admin";

    private static ConnectionJdbs connectionJdbs;

    private FactoryConnection() {

    }

    public static ConnectionDB getConnectionJdbs() {
        if (connectionJdbs == null) {
            initConnectionJdbs();
        }
        return connectionJdbs;
    }

    private static void initConnectionJdbs() {
        connectionJdbs = new ConnectionJdbs(
                DEFAULT_DATABASE_NAME,
                DEFAULT_USERNAME,
                DEFAULT_PASSWORD
        );
    }
}
