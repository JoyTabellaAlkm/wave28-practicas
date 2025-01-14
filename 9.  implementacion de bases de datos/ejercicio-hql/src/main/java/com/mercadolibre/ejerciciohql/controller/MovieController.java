package com.mercadolibre.ejerciciohql.controller;

import com.mercadolibre.ejerciciohql.service.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/actor-rating-higher-than/{rating}")
    public ResponseEntity<?> getMovieWithActorsRatingHigherThanParam(@PathVariable Double rating) {
        return new ResponseEntity<>(movieService.findMoviesWhereActorRatingHigherThanParam(rating), HttpStatus.OK);
    }

    @GetMapping("/genre/{name}")
    public ResponseEntity<?> getMovieWithActorsRatingHigherThanParam(@PathVariable String name) {
        return new ResponseEntity<>(movieService.findMovieByGenre(name), HttpStatus.OK);
    }

}
