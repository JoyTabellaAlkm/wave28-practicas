package com.mercadolibre.Covid19.controller;

import com.mercadolibre.Covid19.dto.SymptomDTO;
import com.mercadolibre.Covid19.dto.response.FindRiskPersonResponseDTO;
import com.mercadolibre.Covid19.dto.response.FindSymptomByNameReponseDTO;
import com.mercadolibre.Covid19.service.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/covid")
public class CovidController {

    @Autowired
    ICovidService _service;

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findSymptom(){
        return new ResponseEntity<List<SymptomDTO>>(_service.getAllSymptom(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomName(@PathVariable String name){
        return new ResponseEntity<FindSymptomByNameReponseDTO>(_service.getSymptomByName(name),HttpStatus.ACCEPTED);
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskPerson(){
        return new ResponseEntity<List<FindRiskPersonResponseDTO>>(_service.getRiskPerson(),HttpStatus.ACCEPTED);
    }
}
