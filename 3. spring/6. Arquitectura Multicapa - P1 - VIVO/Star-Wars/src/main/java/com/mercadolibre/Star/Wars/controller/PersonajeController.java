package com.mercadolibre.Star.Wars.controller;

import com.mercadolibre.Star.Wars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {
    @Autowired
    private IPersonajeService personajeService;

    @GetMapping("")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        return new ResponseEntity<>(personajeService.findByName(name), HttpStatus.OK);
    }
}
