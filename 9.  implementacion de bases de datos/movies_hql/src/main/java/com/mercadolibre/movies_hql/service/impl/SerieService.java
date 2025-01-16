package com.mercadolibre.movies_hql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.movies_hql.entity.Episode;
import com.mercadolibre.movies_hql.entity.Serie;
import com.mercadolibre.movies_hql.repository.IEpisodeRepository;
import com.mercadolibre.movies_hql.repository.ISerieRepository;
import com.mercadolibre.movies_hql.service.ISerieService;

@Service
public class SerieService implements ISerieService {

    @Autowired
    private ISerieRepository serieRepository;

    @Autowired
    private IEpisodeRepository episodeRepository;

    @Override
    public List<Serie> findAllBySeasonQuantityUp(int quantitySeason) {
        return serieRepository.findAllBySeasonQuantityUp(quantitySeason);
    }

    @Override
    public List<Episode> findAllEpisodesByActor(int actorId) {
        return episodeRepository.findAllEpisodesByActor(actorId);
    }

}
