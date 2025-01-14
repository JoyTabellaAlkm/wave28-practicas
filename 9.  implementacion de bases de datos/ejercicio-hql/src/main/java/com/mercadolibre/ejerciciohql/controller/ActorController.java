package com.mercadolibre.ejerciciohql.controller;

import com.mercadolibre.ejerciciohql.service.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {

    IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllActors() {
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActorById(@PathVariable Long id) {
        return new ResponseEntity<>(actorService.findActorById(id), HttpStatus.OK);
    }

    @GetMapping("/has-favorite-movie")
    public ResponseEntity<?> getAllActorsWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.findActorsThatHaveFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/rating-higher-than/{rating}")
    public ResponseEntity<?> getActorsWithRankingHigherThanParam(@PathVariable Double rating) {
        return new ResponseEntity<>(actorService.findActorsWhereRatingHigherThanGiven(rating), HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getActorsInMovie(@PathVariable Long id) {
        return new ResponseEntity<>(actorService.findActorsByMovieId(id), HttpStatus.OK);
    }

}
