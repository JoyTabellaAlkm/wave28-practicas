package com.mercadolibre.movies.controller;

import com.mercadolibre.movies.service.IMovieService;
import com.mercadolibre.movies.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private ISerieService iSerieService;

    @GetMapping("bySeasonAmount")
    public ResponseEntity<?>  getSeriesBySeasonAmount(@RequestParam Integer amount) {
        return new ResponseEntity<>(this.iSerieService.getSeriesBySeasonAmount(amount), HttpStatus.OK);
    }

    @GetMapping("episodesByActor")
    public ResponseEntity<?>  getEpisodesByActor(@RequestParam String actorName) {
        return new ResponseEntity<>(this.iSerieService.getEpisodesByActor(actorName), HttpStatus.OK);
    }
}
