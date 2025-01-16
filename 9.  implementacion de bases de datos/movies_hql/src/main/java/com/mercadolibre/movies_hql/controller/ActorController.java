package com.mercadolibre.movies_hql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.movies_hql.service.IActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private IActorService actorService;

    @GetMapping("/has-favorite-movie")
    public ResponseEntity<?> findAllHasFavoriteMovie() {
        return ResponseEntity.ok(actorService.findAllHasFavoriteMovie());
    }

    @GetMapping("/rating-up/{rating}")
    public ResponseEntity<?> findAllByRatingUp(@PathVariable float rating) {
        return ResponseEntity.ok(actorService.findAllByRatingUp(rating));
    }

    @GetMapping("/work-in-movie/{movieId}")
    public ResponseEntity<?> findAllByWorkInMovie(@PathVariable int movieId) {
        return ResponseEntity.ok(actorService.findAllByWorkInMovie(movieId));
    }

}
