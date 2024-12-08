package com.bootcamp.personajesStarWars.controller;

import com.bootcamp.personajesStarWars.dto.PersonajeDTO;
import com.bootcamp.personajesStarWars.service.impl.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeServiceImpl personajeService;
    @GetMapping("/buscarPersonaje/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(personajeService.findByName(name));
    }
}
