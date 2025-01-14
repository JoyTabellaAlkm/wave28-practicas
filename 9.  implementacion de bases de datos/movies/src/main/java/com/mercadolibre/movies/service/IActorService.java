package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.ActorDto;

import java.math.BigDecimal;
import java.util.List;

public interface IActorService {
    List<ActorDto> obtenerActoresConPeliculaFavorita();
    List<ActorDto> obtenerActoresPorRatingMayor(BigDecimal rating);
    List<ActorDto> obtenerActoresPorPelicula(String movieTitle);
}
