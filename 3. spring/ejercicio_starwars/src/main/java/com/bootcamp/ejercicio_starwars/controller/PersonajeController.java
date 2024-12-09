package com.bootcamp.ejercicio_starwars.controller;

import com.bootcamp.ejercicio_starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {

    @Autowired
    private IPersonajeService personajeService;


    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonajesByName(@PathVariable String name){
        return ResponseEntity.ok(personajeService.getPersonajesByName(name));
    }
}
