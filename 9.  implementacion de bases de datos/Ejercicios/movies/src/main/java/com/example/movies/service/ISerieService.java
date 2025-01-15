package com.example.movies.service;

import com.example.movies.entity.Serie;

import java.util.List;

public interface ISerieService {
    List<Serie> listSeriesHavingSeasonsGreaterThan(int cantTemporadas);
}
