package com.bootcamp.Movies.controller;

import com.bootcamp.Movies.dto.SerieSeasonsCountDto;
import com.bootcamp.Movies.service.ISerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final ISerieService serieService;

    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }

    // Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>.
    @GetMapping("/seasons-number-greater-than/{seasons_number}")
    public ResponseEntity<List<SerieSeasonsCountDto>> seriesWithSeasonsNumberGreaterThan(@PathVariable("seasons_number") Integer seasonsNumber) {
        return ResponseEntity.ok(serieService.seriesWithSeasonsNumberGreaterThan(seasonsNumber));
    }
}
