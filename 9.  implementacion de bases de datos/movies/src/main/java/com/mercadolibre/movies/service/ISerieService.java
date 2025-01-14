package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.EpisodeDTO;
import com.mercadolibre.movies.dto.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> getSeriesBySeasonAmount(Integer amount);
    List<EpisodeDTO> getEpisodesByActor(String actorName);
}
