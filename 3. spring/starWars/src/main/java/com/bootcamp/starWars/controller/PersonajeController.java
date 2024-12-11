package com.bootcamp.starWars.controller;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeServiceImpl personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name) {
        List<PersonajeDTO> personajes;
        try {
            personajes = personajeService.getPersonajesByName(name);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok(personajes);
    }
}
