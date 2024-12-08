package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.dto.RiskPersonDto;
import com.mercadolibre.covid19.dto.SymptomDto;
import com.mercadolibre.covid19.service.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    private final ICovidService covidService;

    public CovidController(ICovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(covidService.findAll());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> findByName(@PathVariable String name) {
        return new ResponseEntity<>(covidService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDto>> findRiskPerson() {
        return ResponseEntity.ok(covidService.findRiskPerson());
    }

}
