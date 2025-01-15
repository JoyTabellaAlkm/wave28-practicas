package com.bootcamp.Movies.service.impl;

import com.bootcamp.Movies.dto.ActorDto;
import com.bootcamp.Movies.dto.MovieActorsDto;
import com.bootcamp.Movies.dto.MovieRatingDto;
import com.bootcamp.Movies.dto.MoviesByGenreDto;
import com.bootcamp.Movies.repository.IGenreRepository;
import com.bootcamp.Movies.repository.IMovieRepository;
import com.bootcamp.Movies.repository.projection.ActorsProjection;
import com.bootcamp.Movies.repository.projection.MovieRatingProjection;
import com.bootcamp.Movies.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final IGenreRepository genreRepository;
    private final IMovieRepository movieRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public MovieService(IGenreRepository genreRepository,
                        IMovieRepository movieRepository) {
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
    }


    @Override
    public MovieActorsDto actorsByMovieId(Integer movieId) {
        String movieTitle = movieRepository.titleByMovieId(movieId);
        List<ActorsProjection> projections = movieRepository.actorsByMovieId(movieId);
        return new MovieActorsDto(movieTitle, projections.stream()
                        .map(actor -> modelMapper.map(actor, ActorDto.class))
                        .toList()
        );
    }

    @Override
    public List<MovieRatingDto> moviesWithRatingGreaterThan(BigDecimal rating) {
        List<MovieRatingProjection> projections = movieRepository.moviesWithRatingGreaterThan(rating);
        return projections.stream()
                .map(projection -> modelMapper.map(projection, MovieRatingDto.class))
                .toList();
    }

    @Override
    public MoviesByGenreDto moviesByGenreId(int genreId) {
        String genreName = genreRepository.nameByGenreId(genreId);
        return new MoviesByGenreDto(genreName, genreRepository.genreMovies(genreId));
    }
}
