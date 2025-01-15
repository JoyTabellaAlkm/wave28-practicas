package com.bootcamp.movies_api.service;

import com.bootcamp.movies_api.dto.SimpleActorWithFavoriteMovieAndRatingDTO;
import com.bootcamp.movies_api.dto.SimpleActorWithRatingDTO;
import com.bootcamp.movies_api.model.Actor;

import java.util.List;

public interface ActorService {
    List<SimpleActorWithFavoriteMovieAndRatingDTO> findByFavoriteMovieIsNotNull();
    List<SimpleActorWithRatingDTO> findByRatingGreaterThan(Double rating);
}
