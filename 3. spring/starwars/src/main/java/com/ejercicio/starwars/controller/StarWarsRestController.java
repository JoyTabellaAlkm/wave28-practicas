package com.ejercicio.starwars.controller;


import com.ejercicio.starwars.dto.CharactersDTO;
import com.ejercicio.starwars.service.CharactersService;
import com.ejercicio.starwars.service.ICharacters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsRestController {
    @Autowired
    public ICharacters charactersService;
    @GetMapping("/characters/{name}")
    public ResponseEntity<List<CharactersDTO>> getCharacters(@PathVariable String name){
        return ResponseEntity.ok(charactersService.getCharactersByName(name));
    }

}
