package com.example.moviefx.controllers;

import com.example.moviefx.models.Movie;
import com.example.moviefx.models.MovieDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PieChartController implements Initializable {
    public PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MovieDao movieDao = new MovieDao();
        List<Movie> movies = movieDao.getAll();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        Map<String, Long> fieldCountMap = movies.stream()
                .flatMap(movie -> Stream.of(movie.getName()))
                .collect(Collectors.groupingBy(
                        fieldName -> fieldName,
                        Collectors.counting()
                ));
        fieldCountMap.forEach((fieldName, count) -> {
            PieChart.Data data = new PieChart.Data(fieldName, count);
            pieChartData.add(data);
        });
        pieChart.setData(pieChartData);
        pieChart.setTitle("Movies Chart!");
    }
}
