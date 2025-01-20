package co.mercadolibre.movieshql.controller;

import co.mercadolibre.movieshql.dto.ResponseActorFavoriteMovieDto;
import co.mercadolibre.movieshql.dto.ResponseActorRatingDto;
import co.mercadolibre.movieshql.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor/")
public class ActorContoller {

    @Autowired
    ActorService actorService;

    @GetMapping("favorite-movie")
    public ResponseEntity<ResponseActorFavoriteMovieDto> getActorsWithFavoriteMovie(){
        return ResponseEntity.ok(actorService.getActorsWithFavoriteMovie());
    }

    @GetMapping("higher-rating/{param}")
    public ResponseEntity<ResponseActorRatingDto> getActorsWithParamRating(@PathVariable Double param){
        return ResponseEntity.ok(actorService.getActorsWithParamRating(param));
    }
}
