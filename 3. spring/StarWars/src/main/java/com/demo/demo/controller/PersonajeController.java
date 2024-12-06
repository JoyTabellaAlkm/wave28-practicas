package com.demo.demo.controller;

import com.demo.demo.dto.PersonajeDTO;
import com.demo.demo.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    PersonajeService personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> buscarPersonaje(
            @PathVariable String name
    ) {
        List<PersonajeDTO> resultado = personajeService.buscarPersonaje(name);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
