package com.ar.mercadolibre.deportistas.controllers;

import com.ar.mercadolibre.deportistas.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonService personService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons() {
        return new ResponseEntity<>(personService.findSportsPersons(), HttpStatus.OK);
    }

}
