package com.example.moviefx.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    private Integer id;
    private String name;
    private String title;
    private String description;
    private Double rate;
}
