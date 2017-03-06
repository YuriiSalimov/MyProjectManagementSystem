package com.management.project.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface ConnectionJdbc {

    Connection getConnection();

    void close();
}
