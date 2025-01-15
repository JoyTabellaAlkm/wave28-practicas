package com.example.movies.controller;

import com.example.movies.entity.Movie;
import com.example.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    IMovieService movieService;
    @GetMapping("/actorRatingGreaterThan/{rating}")
    public ResponseEntity<?> getActorsWithRatingGreaterThan(@PathVariable double rating){
        return new ResponseEntity<>(movieService.listMoviesByActorRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre){
        return new ResponseEntity<>(movieService.listMoviesByGenre(genre),HttpStatus.OK);
    }
}
