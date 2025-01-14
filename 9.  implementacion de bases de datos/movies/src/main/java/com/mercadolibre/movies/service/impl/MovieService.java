package com.mercadolibre.movies.service.impl;

import com.mercadolibre.movies.dto.ActorDto;
import com.mercadolibre.movies.dto.MovieDto;

import com.mercadolibre.movies.model.Movie;
import com.mercadolibre.movies.repository.IMovieRepository;
import com.mercadolibre.movies.service.IMovieService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<MovieDto> obtenerPeliculasPorRatingActor(BigDecimal rating) {
        return movieRepository.findMoviesByActorRating(rating)
                .stream().map(movie->
                        modelMapper.map(movie,MovieDto.class))
                .toList();
    }

    @Override
    public List<MovieDto> obtenerPeliculasPorGenero(String genero) {
        return movieRepository.findMoviesByGenre(genero)
                .stream().map(movie->
                        modelMapper.map(movie,MovieDto.class))
                .toList();
    }
}
