package com.mercadolibre.movies.service.impl;

import com.mercadolibre.movies.repository.ISeriesRepository;
import com.mercadolibre.movies.service.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService implements ISeriesService {
    @Autowired
    ISeriesRepository seriesRepository;

    @Override
    public List<String> obtenerSeriesPorTemporadas(int temporadas) {
        return seriesRepository.findSeriesBySeasonsContaining(temporadas);
    }
}
