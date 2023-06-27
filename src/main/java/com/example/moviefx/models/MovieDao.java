package com.example.moviefx.models;

import com.example.moviefx.databaseUtils.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {

    public boolean insert(Movie movie) {
        try (Connection connection = ConnectionManager.getConnection()){
            try (Statement statement = connection.createStatement()) {
                return statement.execute(String.format("INSERT INTO movie (id, name, title, description, rate) VALUES (%s, '%s', '%s', '%s', %s)",
                        movie.getId(), movie.getName(), movie.getTitle(), movie.getDescription(), movie.getRate()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Movie> getAll() {
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `movie`");
            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = Movie.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .title(resultSet.getString("title"))
                        .description(resultSet.getString("description"))
                        .rate(resultSet.getDouble("rate")).build();
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
