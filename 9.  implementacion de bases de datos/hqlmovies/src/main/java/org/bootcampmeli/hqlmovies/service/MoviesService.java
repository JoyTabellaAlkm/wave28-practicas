package org.bootcampmeli.hqlmovies.service;

import org.bootcampmeli.hqlmovies.model.Movie;
import org.bootcampmeli.hqlmovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAllMovies();
    }

    @Override
    public List<Movie> getByGenre(String genre){
        return movieRepository.getMovieByGenre(genre);

    }

}
