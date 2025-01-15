package com.example.movies.service;

import com.example.movies.entity.Actor;
import com.example.movies.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService{
    @Autowired
    ActorRepository actorRepository;

    @Override
    public List<Actor> listAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public List<Actor> listActorsWithFavoriteMovie() {
        return actorRepository.findActorByFavoriteMovie();
    }

    @Override
    public List<Actor> listActorsWithRankingGreaterThan() {
        return null;
    }

    @Override
    public List<Actor> listActorByRatingGreaterThan(double rating) {
        return actorRepository.findActorByRatingGreaterThan(rating);
    }
}
