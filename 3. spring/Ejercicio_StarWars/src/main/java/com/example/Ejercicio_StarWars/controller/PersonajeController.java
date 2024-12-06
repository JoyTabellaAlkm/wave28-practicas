package com.example.Ejercicio_StarWars.controller;

import com.example.Ejercicio_StarWars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/Personajes")
public class PersonajeController {
    @Autowired
    private final IPersonajeService service;

    public PersonajeController(IPersonajeService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> BuscarPorNombre(@PathVariable String name){
        try{
            return ResponseEntity.ok().body(service.listarDto(name));
        }catch (Exception e) {
            throw new RuntimeException("Error al acceder a los personajes: "+ e.getMessage());
        }
    }
}
