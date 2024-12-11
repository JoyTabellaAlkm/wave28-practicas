package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.PersonajeDto;
import com.bootcamp.starwars.service.PersonajeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    List<PersonajeDto> getPersonajes() {
        return personajeService.searchPersonajes();
    }
}
