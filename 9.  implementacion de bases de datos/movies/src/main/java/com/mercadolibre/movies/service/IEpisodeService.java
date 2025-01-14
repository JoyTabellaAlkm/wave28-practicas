package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> obtenerEpisodiosPorActor(String nombre, String apellido);
}
