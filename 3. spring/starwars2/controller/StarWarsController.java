package com.example.starwars2.controller;

import com.example.starwars2.dto.CharacterDTO;
import com.example.starwars2.service.ICharacterService;
import com.example.starwars2.service.impl.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo/v0.5")
public class StarWarsController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping("searchCharacters/{name}")
    public ResponseEntity<List<CharacterDTO>> searchCharacters(@PathVariable String name){
        System.out.println(name);
        return ResponseEntity.ok(characterService.getCharactersByName(name));
    }

}
