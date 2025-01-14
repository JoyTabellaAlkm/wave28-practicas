package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.ActorDTO;
import com.mercadolibre.movies.dto.MovieDTO;
import com.mercadolibre.movies.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public List<MovieDTO> getMoviesByActorRating(Long rating) {
        List<Object[]> movies =  movieRepository.getMoviesByActorRating(rating);
        return movies.stream().map(MovieDTO::new).toList();
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        List<Object[]> movies =  movieRepository.getMoviesByGenre(genre);
        return movies.stream().map(MovieDTO::new).toList();
    }
}
