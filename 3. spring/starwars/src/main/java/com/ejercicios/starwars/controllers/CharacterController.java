package com.ejercicios.starwars.controllers;

import com.ejercicios.starwars.services.ICharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final ICharacterService characterService;

    public CharacterController(ICharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return new ResponseEntity<>(characterService.getCharactersByName(name), HttpStatus.OK);
    }
}