package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.EpisodeDTO;
import com.mercadolibre.movies.dto.MovieDTO;
import com.mercadolibre.movies.dto.SerieDTO;
import com.mercadolibre.movies.repository.IMovieRepository;
import com.mercadolibre.movies.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {

    @Autowired
    private ISerieRepository serieRepository;

    @Override
    public List<SerieDTO> getSeriesBySeasonAmount(Integer amount) {
        List<Object[]> series =  serieRepository.getSeriesBySeasonAmount(amount);
        return series.stream().map(SerieDTO::new).toList();
    }

    @Override
    public List<EpisodeDTO> getEpisodesByActor(String actorName) {
        List<Object[]> episodes =  serieRepository.getEpisodesByActor(actorName);
        return episodes.stream().map(EpisodeDTO::new).toList();
    }
}
