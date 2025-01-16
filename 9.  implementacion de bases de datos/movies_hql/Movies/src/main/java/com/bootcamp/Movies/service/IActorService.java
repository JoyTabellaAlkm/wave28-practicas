package com.bootcamp.Movies.service;

import com.bootcamp.Movies.dto.ActorDto;
import com.bootcamp.Movies.dto.ActorWithFavouriteMovieDto;

import java.util.List;

public interface IActorService {
    List<ActorWithFavouriteMovieDto> getActorsHavingFavouriteMovie();
    List<ActorDto> getActorsHavingRatingGreaterThan(double rating);
}
