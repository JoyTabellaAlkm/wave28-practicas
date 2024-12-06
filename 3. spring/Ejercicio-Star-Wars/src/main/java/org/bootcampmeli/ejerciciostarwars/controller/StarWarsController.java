package org.bootcampmeli.ejerciciostarwars.controller;


import org.bootcampmeli.ejerciciostarwars.service.StarWarsService;
import org.bootcampmeli.ejerciciostarwars.service.StarWarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StarWarsController {

    @Autowired
    StarWarsServiceImpl starWarsService;


    @GetMapping("/{nombrePersonaje}")
    public ResponseEntity<?> obtenerPersonaje(@PathVariable String nombrePersonaje) {

            return new ResponseEntity<>(starWarsService.personajesPorNombre(nombrePersonaje), HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> obtenerPersonajes() {

        return new ResponseEntity<>(starWarsService.personajes(), HttpStatus.OK);

    }


}
