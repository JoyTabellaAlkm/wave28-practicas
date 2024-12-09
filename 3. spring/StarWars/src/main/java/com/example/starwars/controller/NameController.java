package com.example.starwars.controller;

import com.example.starwars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/personaje")
public class NameController {
    @Autowired
    private CharacterService characterService;
    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) throws IOException {
        return ResponseEntity.ok(characterService.findAllByName(name));
    }
}
