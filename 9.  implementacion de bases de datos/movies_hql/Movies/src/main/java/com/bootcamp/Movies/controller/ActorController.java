package com.bootcamp.Movies.controller;

import com.bootcamp.Movies.dto.ActorDto;
import com.bootcamp.Movies.dto.ActorWithFavouriteMovieDto;
import com.bootcamp.Movies.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    // Listar todos los actores que tengan declarada una película favorita.
    @GetMapping("/having-favourite-movie")
    public ResponseEntity<List<ActorWithFavouriteMovieDto>> getActorsHavingFavouriteMovie() {
        return ResponseEntity.ok(actorService.getActorsHavingFavouriteMovie());
    }

    // Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/having-rating-greater-than/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsHavingRatingGreaterThan(@PathVariable("rating") Double rating) {
        return ResponseEntity.ok(actorService.getActorsHavingRatingGreaterThan(rating));
    }

    // Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>.
//    @GetMapping("/{actor_id}/serie-episodes")
//    public ResponseEntity<java.lang.String> episodesByActor(@PathVariable("actor_id") Integer actorId) {
//        return ResponseEntity.ok("");
//    }
}
