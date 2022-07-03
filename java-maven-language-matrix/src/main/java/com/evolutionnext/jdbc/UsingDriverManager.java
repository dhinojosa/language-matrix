package com.evolutionnext.jdbc;

import java.sql.*;

public class UsingDriverManager {


    public static void main(String[] args) throws SQLException,
        ClassNotFoundException {
        if (args.length != 2) {
            System.out.println("Application needs two arguments, e.g. java com" +
                ".evolutionnext.jdbc.UsingDriverManager <root> <password>");
            System.exit(1);
        }
        String username = args[0];
        String password = args[1];

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql" +
            "://localhost:3306/sakila", username, password);

        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT first_name, last_name from customer where last_name like ? order by first_name");
        preparedStatement.setString(1, "Sa%");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("first_name = %s, last_name = %s;\n", resultSet.getString(1), resultSet.getString(2));
        }

        preparedStatement.close();
        resultSet.close();
        connection.close();
    }
}
