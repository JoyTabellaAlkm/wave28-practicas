package com.starwars.spring.controller;

import com.starwars.spring.service.IPersonajeService;
import com.starwars.spring.dto.PersonajeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PersonajeController {

    private IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        System.out.println("Se esta inicializando el controlador.");

        this.personajeService = personajeService;
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<ArrayList<PersonajeDTO>> findByName(@PathVariable String name){
        return ResponseEntity.ok(
                this.personajeService.findByName(name)
        );
    }

}
