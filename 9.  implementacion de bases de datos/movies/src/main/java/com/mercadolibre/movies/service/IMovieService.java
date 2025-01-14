package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.MovieDto;

import java.math.BigDecimal;
import java.util.List;

public interface IMovieService {
    List<MovieDto> obtenerPeliculasPorRatingActor(BigDecimal rating);
    List<MovieDto> obtenerPeliculasPorGenero(String genero);
}
