package com.mercadolibre.movies.controller;

import com.mercadolibre.movies.service.IActorService;
import com.mercadolibre.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("byActorRating")
    public ResponseEntity<?> getMoviesByActorRating(@RequestParam Long rating) {
        return new ResponseEntity<>(this.movieService.getMoviesByActorRating(rating), HttpStatus.OK);
    }

    @GetMapping("byGenre")
    public ResponseEntity<?> getMoviesByGenre(@RequestParam String genre) {
        return new ResponseEntity<>(this.movieService.getMoviesByGenre(genre), HttpStatus.OK);
    }
}
