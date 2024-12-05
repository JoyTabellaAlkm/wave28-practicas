package com.spring.ejercicios.controllers;

import com.spring.ejercicios.dto.personaDto;
import com.spring.ejercicios.models.Persona;
import com.spring.ejercicios.models.Sintoma;
import com.spring.ejercicios.services.iCovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private iCovidService service;


    @GetMapping("/findSymptom")
    public List<Sintoma> findAllSymptoms() {
        return service.todosSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name) {
        return ResponseEntity.ok(service.existeSintoma(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<personaDto>> findRiskPersons() {
        return ResponseEntity.ok(service.personasRiesgo());
    }
}
