package com.mercadolibre.movies.controller;

import com.mercadolibre.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private IActorService actorService;

    @GetMapping("withFavoriteMovie")
    public ResponseEntity<?> getActorsWithFavoriteMovie() {
        return new ResponseEntity<>(this.actorService.getActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("withRating")
    public ResponseEntity<?> getActorsWithRating(@RequestParam Long rating) {
        return new ResponseEntity<>(this.actorService.getActorsWithRating(rating), HttpStatus.OK);
    }

    @GetMapping("fromMovie")
    public ResponseEntity<?> getActorsFromMovie(@RequestParam String movie) {
        return new ResponseEntity<>(this.actorService.getActorsFromMovie(movie), HttpStatus.OK);
    }
}
