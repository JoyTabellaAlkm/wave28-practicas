package com.mercadolibre.movies.service;

import java.util.List;

public interface ISeriesService {
    List<String> obtenerSeriesPorTemporadas(int temporadas);
}
