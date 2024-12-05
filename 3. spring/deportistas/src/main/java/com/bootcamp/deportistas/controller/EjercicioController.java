package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.service.DeporteService;
import com.bootcamp.deportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EjercicioController {

    @Autowired
    private DeporteService deporteService;
    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return ResponseEntity.ok(deporteService.getAllDeportes());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> findSportByName(@PathVariable String name) {
        Optional<Deporte> dep = deporteService.findBy(name);
        if (dep.isEmpty())
            return ResponseEntity.status(404).build();
        return ResponseEntity.ok(dep.get());
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findDeportistas() {
        return ResponseEntity.ok(personaService.getDeportistas().stream()
                .map(p -> new PersonaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre())).toList());
    }
}
