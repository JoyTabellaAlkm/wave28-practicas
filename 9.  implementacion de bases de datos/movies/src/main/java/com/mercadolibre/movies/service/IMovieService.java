package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> getMoviesByActorRating(Long rating);
    List<MovieDTO> getMoviesByGenre(String genre);
}
