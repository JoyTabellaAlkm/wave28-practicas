package com.mercadolibre.ejerciciohql.service;

import com.mercadolibre.ejerciciohql.dto.MovieDTO;

import java.util.List;

public interface IMovieService {

    List<MovieDTO> findMoviesWhereActorRatingHigherThanParam(Double rating);

}
