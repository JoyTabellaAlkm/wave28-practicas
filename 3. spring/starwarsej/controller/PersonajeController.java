package com.mercadolibre.starwarsej.controller;

import com.mercadolibre.starwarsej.dto.PersonajeDTO;
import com.mercadolibre.starwarsej.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/personajes/{name}")
    public ResponseEntity<?> GetPersonajesName(@PathVariable String name){

        List<PersonajeDTO> listaPersonajesName =personajeService.findByName(name);
        if(!listaPersonajesName.isEmpty()){
            return ResponseEntity.ok(listaPersonajesName);
        }else {
            return ResponseEntity.badRequest().body("Error al obtener personajes con nombre: "+ name);
        }
    }
}
