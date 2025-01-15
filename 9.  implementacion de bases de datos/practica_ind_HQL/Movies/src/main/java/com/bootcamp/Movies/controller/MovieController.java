package com.bootcamp.Movies.controller;

import com.bootcamp.Movies.dto.MovieActorsDto;
import com.bootcamp.Movies.dto.MovieRatingDto;
import com.bootcamp.Movies.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    // Listar todos los actores que trabajan en la <película recibida por parámetro>.
    @GetMapping("/{movie_id}/actors")
    public ResponseEntity<MovieActorsDto> actorsByMovieId(@PathVariable("movie_id") Integer movieId) {
        return ResponseEntity.ok(movieService.actorsByMovieId(movieId));
    }

    // Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>.
    @GetMapping("/rating-greater-than/{rating}")
    public ResponseEntity<List<MovieRatingDto>> actorsWithRatingGreaterThan(@PathVariable("rating") BigDecimal rating) {
        return ResponseEntity.ok(movieService.moviesWithRatingGreaterThan(rating));
    }

    // Listar todas las películas que pertenezcan al <género recibido por parámetro>.
    @GetMapping("genre/{genre_id}")
    public ResponseEntity<java.lang.String> moviesByGenreId(@PathVariable("genre_id") Integer genreId) {
        return ResponseEntity.ok("");
    }
}
