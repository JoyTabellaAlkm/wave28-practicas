package com.mercadolibre.movies_hql.service;

import java.util.List;

import com.mercadolibre.movies_hql.entity.Movie;

public interface IMovieService {

    public List<Movie> findAllByActorRatingUp(double rating);
    public List<Movie> findAllByGenre(int genreId);

}
