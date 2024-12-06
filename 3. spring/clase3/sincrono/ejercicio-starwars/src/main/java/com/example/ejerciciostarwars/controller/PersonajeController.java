package com.example.ejerciciostarwars.controller;

import com.example.ejerciciostarwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/personajes")


public class PersonajeController {
    @Autowired
    IPersonajeService iPersonajeService;
    @GetMapping("/nombre/{name}")
    public ResponseEntity<?> getPersonaje(@PathVariable String name){
        return ResponseEntity.ok(iPersonajeService.obtenerPersonaje(name));
    }
}
