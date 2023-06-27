package com.example.moviefx.controllers;

import com.example.moviefx.MovieApplication;
import com.example.moviefx.models.Movie;
import com.example.moviefx.models.MovieDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieController {
    public TextField id;
    public TextField name;
    public TextField title;
    public TextField description;
    public TextField rate;

    @FXML
    protected void onSave() {
        Movie movie = Movie.builder()
                .id(Integer.parseInt(id.getText()))
                .name(name.getText())
                .title(title.getText())
                .description(description.getText())
                .rate(Double.valueOf(rate.getText()))
                .build();
        MovieDao movieDao = new MovieDao();
        movieDao.insert(movie);
    }

    public void onOpenChart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("piechart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage = new Stage();
        stage.setTitle("PieChart!");
        stage.setScene(scene);
        stage.show();
    }
}