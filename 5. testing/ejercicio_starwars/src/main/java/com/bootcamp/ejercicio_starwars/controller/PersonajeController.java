package com.bootcamp.ejercicio_starwars.controller;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDto;
import com.bootcamp.ejercicio_starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDto>> buscarPorNombre(@RequestParam Optional<String> name) {
        return ResponseEntity.ok(personajeService.findAllWithName(name.orElse("")));
    }

}
