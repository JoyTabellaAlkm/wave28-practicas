package com.bootcamp.movies_api.controller;

import com.bootcamp.movies_api.model.Movie;
import com.bootcamp.movies_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MoviesRestController {

    MovieService movieService;

    @Autowired
    public MoviesRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/filter_by_genre")
    ResponseEntity<List<Movie>> filter(@RequestParam String genre) {
        return ResponseEntity.ok(movieService.findAllByGenre(genre));
    }

    @GetMapping("/filter_by_title")
    ResponseEntity<List<Movie>> filterByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieService.findAllByTitle(title));
    }

}
