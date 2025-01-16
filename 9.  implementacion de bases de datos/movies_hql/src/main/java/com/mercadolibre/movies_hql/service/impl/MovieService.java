package com.mercadolibre.movies_hql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.movies_hql.entity.Movie;
import com.mercadolibre.movies_hql.repository.IMovieRepository;
import com.mercadolibre.movies_hql.service.IMovieService;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public List<Movie> findAllByActorRatingUp(double rating) {
        return movieRepository.findAllByActorRatingUp(rating);
    }

    @Override
    public List<Movie> findAllByGenre(int genreId) {
        return movieRepository.findAllByGenre(genreId);
    }

}
