package com.example.homework3.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    public static Connection getConnection() throws SQLException {
        String userName = "root";
        String password = "zhan2010";
        String connectionUrl = "jdbc:mysql://localhost:3306/hw3database";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(connectionUrl, userName, password);
    }
}
