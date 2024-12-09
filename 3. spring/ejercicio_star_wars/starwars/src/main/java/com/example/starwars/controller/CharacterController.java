package com.example.starwars.controller;

import com.example.starwars.dto.response.GetCharacterResponse;
import com.example.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {
    @Autowired
    private ICharacterService characterService;

    @GetMapping("/findCharacter/{name}")
    public ResponseEntity<GetCharacterResponse> getCharacterByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(characterService.getCharacterByName(name));
    }
}
