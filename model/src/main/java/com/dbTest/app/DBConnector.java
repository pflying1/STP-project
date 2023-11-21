package com.dbTest.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection = null;

    public static Connection getConnection(String url, String username, String password) {
        try {
            // JDBC 드라이버 로드
            Class.forName("org.postgresql.Driver");

            // 데이터베이스 연결
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("데이터베이스 연결 성공!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
