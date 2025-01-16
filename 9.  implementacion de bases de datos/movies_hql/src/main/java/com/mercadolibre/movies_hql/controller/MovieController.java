package com.mercadolibre.movies_hql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.movies_hql.service.IMovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/actor-rating-up/{rating}")
    public ResponseEntity<?> findAllByActorRatingUp(@PathVariable float rating) {
        return ResponseEntity.ok(movieService.findAllByActorRatingUp(rating));
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<?> findAllByGenre(@PathVariable int genreId) {
        return ResponseEntity.ok(movieService.findAllByGenre(genreId));
    }

}
