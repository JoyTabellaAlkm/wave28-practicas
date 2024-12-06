package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.model.Personaje;
import com.mercadolibre.starwars.service.IPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {
    @Autowired
    private IPersonaje iPersonaje;

    @GetMapping("")
    public ResponseEntity<List<PersonajeDTO>> obtenerPersonajes(@RequestParam String nombrePersonaje){
        if(iPersonaje.buscar(nombrePersonaje).isEmpty()){
            return new ResponseEntity<>(List.of(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iPersonaje.buscar(nombrePersonaje), HttpStatus.OK);
    }

}
