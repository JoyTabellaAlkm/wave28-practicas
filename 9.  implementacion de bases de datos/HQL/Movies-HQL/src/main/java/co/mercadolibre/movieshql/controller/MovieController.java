package co.mercadolibre.movieshql.controller;

import co.mercadolibre.movieshql.dto.ResponseMovieActorsDto;
import co.mercadolibre.movieshql.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("list-actors/{movie}")
    public ResponseEntity<ResponseMovieActorsDto> getMovieActorsByMovieName(@PathVariable String movie){
        return ResponseEntity.ok(movieService.getMovieActors(movie));
    }

}
