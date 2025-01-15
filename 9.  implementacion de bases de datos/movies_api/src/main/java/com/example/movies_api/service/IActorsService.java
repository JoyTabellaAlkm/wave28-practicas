package com.example.movies_api.service;

import com.example.movies_api.dto.RequestActorsDto;
import com.example.movies_api.model.Actor;

import java.util.List;

public interface IActorsService {

    List<Actor> getWithFavourites();

    List<Actor> getWithRatingGreaterThan(Double ratingIsGreaterThan);

    Actor create(RequestActorsDto requestActorsDto);
}
