package com.example.movies.service;

import com.example.movies.entity.Movie;

import java.util.List;

public interface IMovieService {
    public List<Movie> listMoviesByActorRatingGreaterThan(double rating);
    public List<Movie> listMoviesByGenre(String genre);
}
