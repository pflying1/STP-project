package com.dbTest.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLConnection {
    private static Connection connection = null;

    public static void main(String[] args) {
        try {
            // JDBC 드라이버 로드
            Class.forName("org.postgresql.Driver");

            // 데이터베이스 연결
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "123123";
            connection = DriverManager.getConnection(url, username, password);

            // 연결 성공 시 테이블 생성 및 데이터 삽입
            if (connection != null) {
                createTable();
                insertData();
            }

            System.out.println("데이터베이스 연결 성공!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 연결 종료
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createTable() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE users (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "age INTEGER" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("테이블 생성 성공!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData() {
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users (name, age) VALUES " +
                    "('John Doe', 25), " +
                    "('Jane Smith', 30)";
            statement.executeUpdate(sql);
            System.out.println("데이터 삽입 성공!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
