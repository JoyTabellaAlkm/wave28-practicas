package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.PersonajeDtoResponse;
import com.mercadolibre.starwars.service.IPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private IPersonaje personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDtoResponse>> devolverPersonajes(@PathVariable String name){
        return ResponseEntity.ok(personajeService.devolverPersonaje(name));
    }
}
