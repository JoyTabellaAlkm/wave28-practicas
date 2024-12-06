package com.example.deportista.controller;

import com.example.deportista.service.DeporteServiceImpl;
import com.example.deportista.service.IDeporteService;
import com.example.deportista.service.IPersonasDeportistas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    private IPersonasDeportistas personasService;

    @GetMapping("/findSportsPersons")
    ResponseEntity<?> findSportsPersons(){
        return new ResponseEntity<>(personasService.buscarPersonasDeportistas(), HttpStatus.OK);
    }
}
