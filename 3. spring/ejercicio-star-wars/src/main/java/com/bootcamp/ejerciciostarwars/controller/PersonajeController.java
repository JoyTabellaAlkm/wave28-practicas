package com.bootcamp.ejerciciostarwars.controller;


import com.bootcamp.ejerciciostarwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {
    @Autowired
    IPersonajeService personajeService;

    @GetMapping("personaje/{nombre}")
    public ResponseEntity<?> getPersonajesPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(personajeService.getPersonajesPorNombre(nombre), HttpStatus.OK);
    }
}
