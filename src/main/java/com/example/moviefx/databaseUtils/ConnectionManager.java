package com.example.moviefx.databaseUtils;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class ConnectionManager {

    public static Connection getConnection() {
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/gio", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
