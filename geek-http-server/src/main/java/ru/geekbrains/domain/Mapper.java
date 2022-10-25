package ru.geekbrains.domain;

import java.sql.*;

public class Mapper {
    private static Connection connection = null;
    private static String URL = "jdbc:mysql://127.0.0.1:3306/geekdb";
    private static String USERNAME = "geek";
    public Mapper() {
        this.connection = connection;
    }

//    public void incert(){
//
//    }
//    public void update(){
//
//    }
//    public void delete(){
//
//    }
    public boolean checkInfo(String username, String password) throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, "12341");
            System.out.println("Соединение с БД");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int checkId = 0;
        Statement statement = connection.createStatement();
        String Sql = "SELECT id, userName FROM user WHERE userName = '" + username+ "'";
        String Sql2 = "SELECT id, password FROM user WHERE password = '" + password + "'";
        ResultSet resultSet2 = statement.executeQuery(Sql2);
        while (resultSet2.next()) {
            if ((resultSet2.getString(2).equals(password))) {
                checkId = resultSet2.getInt(1);
                resultSet2 = statement.executeQuery(Sql);
                while (resultSet2.next()) {
                    if ((resultSet2.getString(2).equals(username))){
                        System.out.println("ТРУx2");
                        if (checkId == resultSet2.getInt(1)){return true;}
                    }
                }
            }
        }
        return false;
    }
}
