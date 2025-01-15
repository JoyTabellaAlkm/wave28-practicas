package com.example.movies.controller;

import com.example.movies.entity.Serie;
import com.example.movies.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    ISerieService serieService;

    @GetMapping("/bySeasonsCount/{seasonsCount}")
    public ResponseEntity<List<Serie>> getSeriesBySeasonsCount(@PathVariable int seasonsCount){
        return new ResponseEntity<>(serieService.listSeriesHavingSeasonsGreaterThan(seasonsCount), HttpStatus.OK);
    }
}
