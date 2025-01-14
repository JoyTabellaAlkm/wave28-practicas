package com.demo.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {

    // Listar todos los actores que tengan declarada una película favorita.
    @GetMapping
    public ResponseEntity<?> actorsWithFavoriteMovie() {
        return ResponseEntity.ok(null);
    }


}
