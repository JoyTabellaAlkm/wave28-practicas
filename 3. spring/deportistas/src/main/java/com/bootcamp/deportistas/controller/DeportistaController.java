package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.DeportistaDTO;
import com.bootcamp.deportistas.service.IDeportistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeportistaController {

    private final IDeportistaService deporteService;

    public DeportistaController(IDeportistaService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        List<DeporteDTO> deportes = deporteService.findSports();
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String name) {
        Optional<DeporteDTO> deporte = deporteService.findSportByName(name);
        return deporte
                .map(deporteDTO -> new ResponseEntity<>(deporteDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<DeportistaDTO> deportistas = deporteService.findSportPersons();
        return new ResponseEntity<>(deportistas, HttpStatus.OK);
    }
}