package com.bootcamp.movies_api.service;

import com.bootcamp.movies_api.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    List<Movie> findAllByGenre(String genre);
    List<Movie> findAllByTitle(String title);
}
