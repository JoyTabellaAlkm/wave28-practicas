package com.mercadolibre.movies.controller;

import com.mercadolibre.movies.dto.ActorDto;
import com.mercadolibre.movies.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
    @Autowired
    IActorService actorService;

    @GetMapping("/movies_fav")
    public ResponseEntity<List<ActorDto>> obtenerActoresPeliculaFav(){
        return new ResponseEntity<>(actorService.obtenerActoresConPeliculaFavorita(), HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ActorDto>> obtenerActoresPorRatingMayor(@PathVariable BigDecimal rating){
        return new ResponseEntity<>(actorService.obtenerActoresPorRatingMayor(rating), HttpStatus.OK);
    }

    @GetMapping("/movie/{movie}")
    public ResponseEntity<List<ActorDto>> obtenerActoresPorPelicula(@PathVariable String movie){
        return new ResponseEntity<>(actorService.obtenerActoresPorPelicula(movie), HttpStatus.OK);
    }
}
