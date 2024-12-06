package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.dto.PersonaDTO;
import com.mercadolibre.covid19.repository.CRUD;
import com.mercadolibre.covid19.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    IPersonaService personaService;

    @GetMapping("/buscarPersonasDeRiesgo")
    public ResponseEntity<List<PersonaDTO>> buscarPersonasDeRiesgo(){

        return new ResponseEntity<>(personaService.buscarPersonasDeRiesgo(),HttpStatus.OK);
    }


}
