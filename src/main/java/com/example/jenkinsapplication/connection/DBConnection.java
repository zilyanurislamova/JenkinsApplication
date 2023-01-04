package com.example.jenkinsapplication.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection connection;

    private static Properties properties;

    private static final String propertiesFile = "connection.properties";

    private DBConnection() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            DBConnection dbConnection = new DBConnection();
            dbConnection.loadProperties();

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    private void loadProperties() {
        properties = new Properties();

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFile)){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
