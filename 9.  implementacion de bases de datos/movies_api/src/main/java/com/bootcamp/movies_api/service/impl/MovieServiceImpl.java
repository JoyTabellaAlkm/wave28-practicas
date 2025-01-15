package com.bootcamp.movies_api.service.impl;

import com.bootcamp.movies_api.dto.MovieWithActorsDTO;
import com.bootcamp.movies_api.dto.SimpleActorWithRatingDTO;
import com.bootcamp.movies_api.exception.ResourceNotFoundException;
import com.bootcamp.movies_api.model.Actor;
import com.bootcamp.movies_api.model.Movie;
import com.bootcamp.movies_api.repository.MovieRepository;
import com.bootcamp.movies_api.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
    ModelMapper modelMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public MovieWithActorsDTO findActorByMovieTitle(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isEmpty()) {
            throw new ResourceNotFoundException("No se ha encontrado el recurso 'movie' con el ID: " + id);
        }
        return modelMapper.map(optionalMovie.get(), MovieWithActorsDTO.class);
    }

    @Override
    public List<Movie> findAllByGenreName(String name) {
        return movieRepository.findAllByGenreName(name);
    }
}
