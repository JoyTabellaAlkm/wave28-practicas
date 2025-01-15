package com.example.movies.service;

import com.example.movies.entity.Actor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorService {
    public List<Actor> listAllActors();
    public List<Actor> listActorsWithFavoriteMovie();
    public List<Actor> listActorsWithRankingGreaterThan();
    List<Actor> listActorByRatingGreaterThan(double rating);

}
