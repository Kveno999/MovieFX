package com.example.moviefx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.xml.transform.Result;
import java.sql.*;

public class HelloController {
    public Label id;
    public Label name;
    public Label title;
    public Label description;
    public Label rate;

    @FXML
    protected void onHelloButtonClick() {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/gio", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `movie` WHERE 1");
            while (resultSet.next()) {
                id.setText(String.valueOf(resultSet.getInt("id")));
                name.setText(String.valueOf(resultSet.getString("name")));
                title.setText(String.valueOf(resultSet.getString("title")));
                description.setText(String.valueOf(resultSet.getString("description")));
                rate.setText(String.valueOf(resultSet.getDouble("rate")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}