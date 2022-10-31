package ru.geekbrains.domain;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Mapper {
    private static Connection connection;
    private static final Map<Integer, UserV> userNameMap = new HashMap<>();
    private static String URL = "jdbc:mysql://127.0.0.1:3306/geekdb";
    private static   int constructID;
    private static String constructName;
    private static String constructPassword;
    private static String USERNAME = "geek";
    public Mapper(Connection connection) {
        this.connection = connection;
    }

    public void incert(String name, String password) throws SQLException {
          DataConnection.statement.executeUpdate("INSERT INTO user (userName, password) VALUE (' " + name + "', '" + password +"')");
    }
    public void update(int i, String name, String password) throws SQLException{
          DataConnection.statement.executeUpdate("UPDATE user SET  userName = '" + name +"', password = '" + password +"' WHERE id = " + i);
    }
    public void delete(int i) throws SQLException{
        DataConnection.statement.executeUpdate("DELETE FROM username WHERE id = " + i);
    }
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
    public Optional<UserV> checkInfoWithMapper (int idFromScanner, String nameFromScanner) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                " SELECT id, name, post FROM username WHERE id = ?"
        );
        UserV name =  userNameMap.get(idFromScanner);
        if(name != null){
            return Optional.of(name)
                    .filter(userName1 -> name.getUserName().equals(nameFromScanner));
        }
        try {
            statement.setInt(1,idFromScanner);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                UserV userData = new UserV(constructID,constructName,constructPassword);
                userData.setId(resultSet.getInt(1));
                userData.setUserName(resultSet.getString(2));
                userData.setPassword(resultSet.getString(3));
                userNameMap.put(idFromScanner, userData);
                return Optional.ofNullable(userNameMap.get(idFromScanner))
                        .filter(userName1 -> userData.getUserName().equals(nameFromScanner));

            }
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }
}
