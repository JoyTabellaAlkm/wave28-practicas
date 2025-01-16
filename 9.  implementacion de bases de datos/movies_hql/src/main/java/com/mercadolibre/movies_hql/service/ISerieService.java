package com.mercadolibre.movies_hql.service;

import java.util.List;

import com.mercadolibre.movies_hql.entity.Episode;
import com.mercadolibre.movies_hql.entity.Serie;

public interface ISerieService {

    public List<Serie> findAllBySeasonQuantityUp(int quantitySeason);
    public List<Episode> findAllEpisodesByActor(int actorId);

}
