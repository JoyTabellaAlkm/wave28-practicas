package com.mercadolibre.movies_hql.service;

import java.util.List;

import com.mercadolibre.movies_hql.entity.Actor;

public interface IActorService {

    public List<Actor> findAllHasFavoriteMovie();
    public List<Actor> findAllByRatingUp(float rating);
    public List<Actor> findAllByWorkInMovie(int movieId);

}
