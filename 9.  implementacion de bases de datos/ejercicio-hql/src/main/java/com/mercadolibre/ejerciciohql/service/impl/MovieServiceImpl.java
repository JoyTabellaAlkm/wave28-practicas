package com.mercadolibre.ejerciciohql.service.impl;

import com.mercadolibre.ejerciciohql.dto.ActorDTO;
import com.mercadolibre.ejerciciohql.dto.MovieDTO;
import com.mercadolibre.ejerciciohql.entity.Actor;
import com.mercadolibre.ejerciciohql.entity.Movie;
import com.mercadolibre.ejerciciohql.repository.IMovieRepository;
import com.mercadolibre.ejerciciohql.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    IMovieRepository movieRepository;
    ModelMapper modelMapper = new ModelMapper();

    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<MovieDTO> findMoviesWhereActorRatingHigherThanParam(Double rating) {
        List<Movie> movies = movieRepository.findMoviesWhereActorRatingHigherThanParam(rating);
        return movieListToMovieDTOList(movies);
    }

    @Override
    public List<MovieDTO> findMovieByGenre(String genreName) {
        List<Movie> movies = movieRepository.findMoviesByGenreName(genreName);
        return movieListToMovieDTOList(movies);
    }


    /**
     *
     * @param movies Lista de Movie
     * @return Lista de MovieDTO
     */
    private List<MovieDTO> movieListToMovieDTOList(List<Movie> movies) {
        return movies
                .stream()
                .map(m -> modelMapper.map(m, MovieDTO.class))
                .toList();
    }

}
