package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.dto.PersonDTO;
import com.mercadolibre.covid19.dto.SymptomDTO;
import com.mercadolibre.covid19.service.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    private ICovidService service;

    public CovidController(ICovidService service) {
        this.service = service;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findAllSymptoms(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDTO>> findRiskPerson() {
        return ResponseEntity.ok(service.findRiskPerson());
    }
}
