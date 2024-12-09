package com.bootcamp.ejercicio_covid.controller;

import com.bootcamp.ejercicio_covid.dto.PersonDto;
import com.bootcamp.ejercicio_covid.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDto>> findRiskPerson() {
        return ResponseEntity.ok(personService.findRiskPerson());
    }
}
