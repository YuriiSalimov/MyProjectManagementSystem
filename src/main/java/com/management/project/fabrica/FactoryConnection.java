package com.management.project.fabrica;

import com.management.project.connection.ConnectionJdbc;
import com.management.project.connection.ConnectionJdbcImpl;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class FactoryConnection {

    private final static String DEFAULT_DATABASE_NAME = "projectManagementDB";

    private final static String DEFAULT_USERNAME = "root";

    private final static String DEFAULT_PASSWORD = "admin";

    private static ConnectionJdbcImpl connectionJdbcImpl;

    private FactoryConnection() {

    }

    public static ConnectionJdbc getConnectionJdbcImpl() {
        if (connectionJdbcImpl == null) {
            initConnectionJdbs();
        }
        return connectionJdbcImpl;
    }

    private static void initConnectionJdbs() {
        connectionJdbcImpl = new ConnectionJdbcImpl(
                DEFAULT_DATABASE_NAME,
                DEFAULT_USERNAME,
                DEFAULT_PASSWORD
        );
    }
}
