package com.spring.ejercicios.controllers;

import com.spring.ejercicios.dto.PersonaDeportistaDTO;
import com.spring.ejercicios.services.iDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {

    @Autowired
    iDeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<String>> findAllSports() {
        return ResponseEntity.ok(deporteService.allSports());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        return ResponseEntity.ok(deporteService.findSportByName(name));
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> findSportsPersons() {
        return ResponseEntity.ok(deporteService.findSportsPersons());
    }
}
