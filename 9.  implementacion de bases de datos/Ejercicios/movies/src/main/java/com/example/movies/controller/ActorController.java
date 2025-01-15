package com.example.movies.controller;

import com.example.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("actors")
public class ActorController {
    @Autowired
    IActorService actorService;
    @GetMapping()
    public ResponseEntity<?> getAllActors(){
        return new ResponseEntity<>(actorService.listAllActors(), HttpStatus.OK);
    }

    @GetMapping("/favoriteMovie")
    public ResponseEntity<?> getAllActorsWithFavoriteMovie(){
        return new ResponseEntity<>(actorService.listActorsWithFavoriteMovie(),HttpStatus.OK);
    }

    @GetMapping("/ratingGreaterThan/{rating}")
    public ResponseEntity<?> getAllActorsWithRatingGreaterThan(@PathVariable double rating){
        return new ResponseEntity<>(actorService.listActorByRatingGreaterThan(rating),HttpStatus.OK);
    }
}
