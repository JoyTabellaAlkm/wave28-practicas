package com.example.Starwars.controller;

import com.example.Starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired
    private IPersonajeService iPersonajeService;

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        try {
            return ResponseEntity.ok(iPersonajeService.findAllByName(name));
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
}
