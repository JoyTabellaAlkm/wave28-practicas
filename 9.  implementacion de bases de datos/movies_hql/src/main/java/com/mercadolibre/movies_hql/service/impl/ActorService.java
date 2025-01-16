package com.mercadolibre.movies_hql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.movies_hql.entity.Actor;
import com.mercadolibre.movies_hql.repository.IActorRepository;
import com.mercadolibre.movies_hql.service.IActorService;

@Service
public class ActorService implements IActorService {

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<Actor> findAllHasFavoriteMovie() {
        return actorRepository.findAllHasFavoriteMovie();
    }

    @Override
    public List<Actor> findAllByRatingUp(float rating) {
        return actorRepository.findAllByRatingUp(rating);
    }

    @Override
    public List<Actor> findAllByWorkInMovie(int movieId) {
        return actorRepository.findAllByWorkInMovie(movieId);
    }

}
