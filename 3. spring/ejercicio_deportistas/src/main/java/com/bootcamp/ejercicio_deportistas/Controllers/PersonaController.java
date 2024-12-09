package com.bootcamp.ejercicio_deportistas.Controllers;

import com.bootcamp.ejercicio_deportistas.Services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    IPersonaService personService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons() {
        return new ResponseEntity<>(personService.buscarPersonasConDeportes(), HttpStatus.OK);
    }
}
