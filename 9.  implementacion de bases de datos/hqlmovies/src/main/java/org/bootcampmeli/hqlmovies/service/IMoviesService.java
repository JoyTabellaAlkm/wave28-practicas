package org.bootcampmeli.hqlmovies.service;

import org.bootcampmeli.hqlmovies.model.Movie;

import java.util.List;

public interface IMoviesService {
    List<Movie> getMovies();

    List<Movie> getByGenre(String genre);
}
