package com.ar.mercadolibre.ejerciciocovid.controller;

import com.ar.mercadolibre.ejerciciocovid.DTO.PatientDTO;
import com.ar.mercadolibre.ejerciciocovid.service.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskPeople() {
        List<PatientDTO> patients = personService.findRiskPeople();

        if(patients.isEmpty()) {
            return new ResponseEntity<>("No risk patients detected", HttpStatus.OK);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
