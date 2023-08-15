package com.example.tickit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.DriverManager;





public class JDBC {

    private static String driver;
    private static String username;
    private static String password;
    private static String url;

    public static Connection connection;
    public static Connection con;

    public static void openConnection() throws IOException, ClassNotFoundException, SQLException {

        FileInputStream fis = new FileInputStream("properties/db_connection.properties");
        Properties properties = new Properties();
        properties.load(fis);

        username = properties.getProperty("username");
        System.out.println(username);
        password = properties.getProperty("password");
        url = properties.getProperty("url");
        driver = properties.getProperty("driver");
        Class.forName(driver); // Locate Driver
        connection = DriverManager.getConnection(url, username, password); // Reference Connection object
        System.out.println("connection opened");
    }

    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("connection closed");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }

}
