package com.bootcamp.movies_api.service.impl;

import com.bootcamp.movies_api.model.Movie;
import com.bootcamp.movies_api.repository.MovieRepository;
import com.bootcamp.movies_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    @Override
    public List<Movie> findAllByTitle(String title) {
        return movieRepository.findAllByTitle(title);
    }
}
