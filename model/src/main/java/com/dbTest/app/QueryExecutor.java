package com.dbTest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class QueryExecutor {
    private static Connection connection = null;

    public static void main(String[] args) {
        SpringApplication.run(QueryExecutor.class, args);
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "123123";

        connection = DBConnector.getConnection(url, username, password);

        if (connection != null) {
            createTable();
            insertData();
        }

        DBConnector.closeConnection();
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
