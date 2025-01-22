package com.example.Covid19.controller;

import com.example.Covid19.dto.PersonRiskDto;
import com.example.Covid19.dto.SymptomDto;
import com.example.Covid19.service.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/health")
public class HealthController {
    private final ICovidService iCovidService;

    public HealthController(ICovidService iCovidService) {
        this.iCovidService = iCovidService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iCovidService.findAll());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> findByName(@PathVariable String name) {
        return new ResponseEntity<>(iCovidService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonRiskDto>> findRiskPerson() {
        return ResponseEntity.ok(iCovidService.findRiskPerson());
    }
}
