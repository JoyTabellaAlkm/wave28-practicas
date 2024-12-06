package com.ejerciciodeportistas.ejerciciodeportistas.controller;

import com.ejerciciodeportistas.ejerciciodeportistas.dto.response.PersonaDTO;
import com.ejerciciodeportistas.ejerciciodeportistas.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PersonaController {

    @Autowired
    private IPersona personaService;

    @PostMapping("/persona")
    public ResponseEntity<?> agregarPersona(@RequestBody PersonaDTO personaDto){
        return new ResponseEntity<?>(personaService.agregarPersona(personaDto, HttpStatus.OK));
    }
}
