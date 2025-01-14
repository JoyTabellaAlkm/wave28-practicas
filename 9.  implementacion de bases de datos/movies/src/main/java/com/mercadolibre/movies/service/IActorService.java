package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.ActorDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> getActorsWithFavoriteMovie();
    List<ActorDTO> getActorsWithRating(Long rating);
    List<ActorDTO> getActorsFromMovie(String movie);
}
