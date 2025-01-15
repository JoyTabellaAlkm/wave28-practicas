package com.example.movies.service;

import com.example.movies.entity.Movie;
import com.example.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService{
    @Autowired
    MovieRepository movieRepository;
    @Override
    public List<Movie> listMoviesByActorRatingGreaterThan(double rating) {
        return movieRepository.findMoviesByActorRatingGreaterThan(rating);
    }

    @Override
    public List<Movie> listMoviesByGenre(String genre) {
        return movieRepository.findMoviesByGenre(genre);
    }
}
