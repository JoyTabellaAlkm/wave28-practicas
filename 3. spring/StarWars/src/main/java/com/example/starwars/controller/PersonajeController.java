package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonajeController {

    private final PersonajeService service;

    @Autowired
    public PersonajeController(PersonajeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String testing(){
        return "Testing";
    }

    @GetMapping("/buscar")
    public List<PersonajeDTO> getPersonajes(@RequestParam String name) {
        return service.findPersonajesByName(name);
    }
}
