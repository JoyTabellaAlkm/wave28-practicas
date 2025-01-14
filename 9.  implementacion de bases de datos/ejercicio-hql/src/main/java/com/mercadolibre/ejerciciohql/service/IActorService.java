package com.mercadolibre.ejerciciohql.service;

import com.mercadolibre.ejerciciohql.dto.ActorDTO;
import com.mercadolibre.ejerciciohql.entity.Actor;

import java.util.List;

public interface IActorService {

    ActorDTO findActorById(Long id);

    List<ActorDTO> getAllActors();

    List<ActorDTO> findActorsThatHaveFavoriteMovie();

    List<ActorDTO> findActorsWhereRatingHigherThanGiven(Double rating);

    List<ActorDTO> findActorsByMovieId(Long id);

}
