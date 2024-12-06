package com.example.starwars.controller;

import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;
    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(personajeService.findAllByName(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
