package com.example.movies_api.controller;

import com.example.movies_api.dto.RequestActorsDto;
import com.example.movies_api.service.impl.ActorsService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("actors")
public class ActorsController {
    @Autowired
    private ActorsService actorsService;

    @GetMapping("favorites")
    public ResponseEntity<?> indexByFavourites(){
        return new ResponseEntity<>(actorsService.getWithFavourites(), HttpStatus.OK);
    }

    @GetMapping("rating")
    public ResponseEntity<?> indexByRating(@RequestParam Double rating){
        return new ResponseEntity<>(actorsService.getWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody RequestActorsDto requestActorsDto){
        return new ResponseEntity<>(actorsService.create(requestActorsDto), HttpStatus.CREATED);
    }
}
