package org.example;

import java.sql.*;

public class Question {
    public static void answer() throws SQLException {
        //1- get a connection
        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String userName = "postgres";
        String password = "22032218";

        Connection connection = DriverManager.getConnection(dbURL, userName, password);
        //2- create a statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //3- execute a query
        String firstQuery = "SELECT title FROM film";
        ResultSet resultSet = statement.executeQuery(firstQuery);
        //4- process the resultset

        int count = 1;
        // boolean
        while (resultSet.next()) {
            System.out.println(count++ + " : " + resultSet.getString("title"));

        }
    }
}
