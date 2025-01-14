package com.mercadolibre.movies.controller;


import com.mercadolibre.movies.dto.MovieDto;
import com.mercadolibre.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    IMovieService movieService;

    @GetMapping("/actor/{rating}")
    public ResponseEntity<List<MovieDto>> obtenerPeliculasPorRatingActor(@PathVariable BigDecimal rating){
        return ResponseEntity.ok(movieService.obtenerPeliculasPorRatingActor(rating));
    }

    @GetMapping("/{genero}")
    public ResponseEntity<List<MovieDto>> obtenerPeliculasPorGenero(@PathVariable String genero){
        return ResponseEntity.ok(movieService.obtenerPeliculasPorGenero(genero));
    }
}
