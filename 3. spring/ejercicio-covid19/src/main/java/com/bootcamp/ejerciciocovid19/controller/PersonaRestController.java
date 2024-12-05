package com.bootcamp.ejerciciocovid19.controller;

import com.bootcamp.ejerciciocovid19.dto.PersonaRiesgoDto;
import com.bootcamp.ejerciciocovid19.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonaRestController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDto>> obtenerPoblacionDeRiesgo() {
        return new ResponseEntity<>(personaService.buscarPoblacionDeRiesgo(), HttpStatus.OK);
    }
}
