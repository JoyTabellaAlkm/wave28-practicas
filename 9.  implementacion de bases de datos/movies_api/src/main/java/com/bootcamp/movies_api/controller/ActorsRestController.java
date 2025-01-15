package com.bootcamp.movies_api.controller;

import com.bootcamp.movies_api.repository.ActorRepository;
import com.bootcamp.movies_api.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actors")
public class ActorsRestController {

    ActorRepository actorRepository;
    ActorService actorService;

    @Autowired
    public ActorsRestController(ActorRepository actorRepository, ActorService actorService) {
        this.actorRepository = actorRepository;
        this.actorService = actorService;
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        return ResponseEntity.ok(actorRepository.findAll());
    }

    @GetMapping("/favorite_movie")
    ResponseEntity<?> findAllByFavoriteMovieIsNotNull() {
        return ResponseEntity.ok(actorService.findByFavoriteMovieIsNotNull());
    }

    @GetMapping("/rating/greater_than")
    ResponseEntity<?> findByRatingGreaterThan(@RequestParam Double rating) {
        return ResponseEntity.ok(actorService.findByRatingGreaterThan(rating));
    };
}
