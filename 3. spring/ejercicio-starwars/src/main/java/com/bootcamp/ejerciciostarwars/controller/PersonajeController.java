package com.bootcamp.ejerciciostarwars.controller;

import com.bootcamp.ejerciciostarwars.dto.PersonajeDTO;
import com.bootcamp.ejerciciostarwars.service.PersonajeService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    private PersonajeService personajeService;


    @GetMapping("/{name}")
    public ResponseEntity<?> findPersonajeByName(
            @PathVariable String name) {

        List<PersonajeDTO> personajeDTOS;

        try {
            personajeDTOS = personajeService.findPersonajeByName(name);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok(personajeDTOS);
    }


}
