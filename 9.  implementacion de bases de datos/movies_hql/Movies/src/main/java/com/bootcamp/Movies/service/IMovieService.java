package com.bootcamp.Movies.service;

import com.bootcamp.Movies.dto.MovieActorsDto;
import com.bootcamp.Movies.dto.MovieRatingDto;
import com.bootcamp.Movies.dto.MoviesByGenreDto;

import java.math.BigDecimal;
import java.util.List;

public interface IMovieService {
    MovieActorsDto actorsByMovieId(Integer movieId);
    List<MovieRatingDto> moviesWithRatingGreaterThan(BigDecimal rating);
    MoviesByGenreDto moviesByGenreId(int genreId);
}
