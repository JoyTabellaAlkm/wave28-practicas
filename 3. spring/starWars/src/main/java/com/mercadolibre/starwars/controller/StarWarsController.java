package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class StarWarsController {

    @Autowired
    private IStarWarsService starWarsService;

    @GetMapping("")
    public ResponseEntity<?> getCharactersByName(@RequestParam String name) {
        return new ResponseEntity<>(starWarsService.getCharactersByName(name), HttpStatus.OK);
    }
}
