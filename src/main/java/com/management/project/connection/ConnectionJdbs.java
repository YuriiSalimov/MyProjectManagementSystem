package com.management.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public final class ConnectionJdbs implements ConnectionDB {

    private String username;

    private String password;

    private String databaseName;

    private boolean autoReconnect = true;

    private boolean useSSL = false;

    private Connection connection;

    public ConnectionJdbs(String databaseName, String username, String password) {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (this.connection == null) {
            initDataSource();
        }
        return this.connection;
    }

    @Override
    public void close() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
        }
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String passowrd) {
        this.password = passowrd;
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public boolean isAutoReconnect() {
        return this.autoReconnect;
    }

    public void setAutoReconnect(boolean autoReconnect) {
        this.autoReconnect = autoReconnect;
    }

    public boolean isUseSSL() {
        return this.useSSL;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private void initDataSource() throws SQLException {
        this.connection = DriverManager.getConnection(getDatabaseUrl(), this.username, this.password);
    }

    private String getDatabaseUrl() {
        return "jdbc:mysql://localhost:3306/" + this.databaseName +
                "?autoReconnect="+ this.autoReconnect + "&useSSL=" + this.useSSL;
    }
}
