package org.moviesbd.controller;

import org.moviesbd.entity.*;
import org.moviesbd.service.iMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class moviesController {
    @Autowired
    private iMovieService service;

    @GetMapping("/find")
    public ResponseEntity<List<genres>> get() {
        return new ResponseEntity<>(service.find(), HttpStatus.OK);
    }

    @GetMapping("/actorsFavoriteMovies")
    public ResponseEntity<List<actors>> getFavoriteMovie() {
        return new ResponseEntity<>(service.favoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/raitingGrater")
    public ResponseEntity<List<actors>> getRatingGrater(@RequestParam float nro) {
        return new ResponseEntity<>(service.raitingGraterThan(nro), HttpStatus.OK);
    }

    @GetMapping("/actorsWorkIn")
    public ResponseEntity<List<actors>> getActorsWork(@RequestParam String name) {
        return new ResponseEntity<>( service.workIn(name), HttpStatus.OK);
    }

    @GetMapping("/moviesActorRaiting")
    public ResponseEntity<List<movies>> getMoviesActorsRaiting(@RequestParam float valor) {
        return new ResponseEntity<>(service.actorsRaiting(valor), HttpStatus.OK);
    }

    @GetMapping("/moviesGenre")
    public ResponseEntity<List<movies>> getMoviesGenre(@RequestParam String titulo) {
        return new ResponseEntity<>(service.moviesGenres(titulo), HttpStatus.OK);
    }

    @GetMapping("/serieSeasons")
    public ResponseEntity<List<series>> getSerieSeasons(@RequestParam int seasons) {
        return new ResponseEntity<>(service.seriesSeasons(seasons), HttpStatus.OK);
    }

    @GetMapping("/episodesActor")
    public ResponseEntity<List<episodes>> getEpisodeActor(@RequestParam String actor) {
        return new ResponseEntity<>(service.episodesActor(actor), HttpStatus.OK);
    }
}
