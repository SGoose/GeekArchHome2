package ru.geekbrains.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnection{
    private static String URL = "jdbc:mysql://127.0.0.1:3306/geekdb";
    private static String USERNAME = "geek";
    public static Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, "12341");
        } catch (SQLException throwable){
            throwable.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwable){
            throwable.printStackTrace();
            throw new RuntimeException();
        }
    }

}
