package com.ar.mercadolibre.ejerciciocovid.controller;

import com.ar.mercadolibre.ejerciciocovid.DTO.SymptomDTO;
import com.ar.mercadolibre.ejerciciocovid.service.ISymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/symptom")
public class SymptomController {

    private final ISymptomService symptomService;

    public SymptomController(ISymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findSymptoms() {
        return new ResponseEntity<>(symptomService.findSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable String name) {
        SymptomDTO symptomDTO = symptomService.findSymptomByName(name);
        if(symptomDTO == null) {
            return new ResponseEntity<>("No valid name provided for that symptom", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(symptomDTO, HttpStatus.OK);
    }
}
