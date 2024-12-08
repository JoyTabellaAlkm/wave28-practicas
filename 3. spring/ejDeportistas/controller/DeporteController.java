package com.mercadolibre.deportistas.controller;

import com.mercadolibre.deportistas.service.impl.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deportes")
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<?> getSports() {
        return new ResponseEntity<>(deporteService.getSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getSportsByName(@PathVariable String name) {
        return new ResponseEntity<>(deporteService.getSportByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> getSportsPersons() {
        return new ResponseEntity<>(deporteService.getSportsPersons(), HttpStatus.OK);
    }
}
