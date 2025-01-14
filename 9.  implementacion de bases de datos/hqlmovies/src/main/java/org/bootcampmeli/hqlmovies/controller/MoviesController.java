package org.bootcampmeli.hqlmovies.controller;

import org.bootcampmeli.hqlmovies.service.IMoviesService;
import org.bootcampmeli.hqlmovies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    private IMoviesService moviesService;

    @GetMapping("/getMovies")
    public ResponseEntity<?> getActorsWithFavourite(){

        return new ResponseEntity<>(moviesService.getMovies(), HttpStatus.OK);

    }
    @GetMapping("/getMovieByGenre")
    public ResponseEntity<?> getMovieByGenre(@RequestParam String genre) {
        return new ResponseEntity<>(moviesService.getByGenre(genre), HttpStatus.OK);
    }

}
