package com.bootcamp.ejercicio_covid.controller;

import com.bootcamp.ejercicio_covid.dto.PersonDto;
import com.bootcamp.ejercicio_covid.dto.SymptomDto;
import com.bootcamp.ejercicio_covid.service.IPersonService;
import com.bootcamp.ejercicio_covid.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SymptomController {
    @Autowired
    private ISymptomService symptomService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> findSymptom() {
        return ResponseEntity.ok(symptomService.findAll());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findRiskPerson(@PathVariable String name) {
        return ResponseEntity.ok(symptomService.findGravityLevelByName(name));
    }
}
