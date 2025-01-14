package com.mercadolibre.movies.controller;

import com.mercadolibre.movies.service.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SeriesController {
    @Autowired
    ISeriesService seriesService;

    @GetMapping("/{temporadas}")
    public ResponseEntity<List<String>> obtenerSeriesPorTemporadas(@PathVariable int temporadas){
        return ResponseEntity.ok(seriesService.obtenerSeriesPorTemporadas(temporadas));
    }
}
