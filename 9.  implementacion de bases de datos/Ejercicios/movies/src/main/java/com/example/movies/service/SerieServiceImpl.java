package com.example.movies.service;

import com.example.movies.entity.Serie;
import com.example.movies.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService{
    @Autowired
    SerieRepository serieRepository;
    @Override
    public List<Serie> listSeriesHavingSeasonsGreaterThan(int cantTemporadas) {
        return serieRepository.findBySeasonsCountGreaterThan(cantTemporadas);
    }
}
