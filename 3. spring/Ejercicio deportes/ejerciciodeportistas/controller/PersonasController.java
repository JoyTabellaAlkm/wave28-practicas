package com.example.ejerciciodeportistas.controller;

import com.example.ejerciciodeportistas.model.Persona;
import com.example.ejerciciodeportistas.model.PersonaConDeporteDTO;
import com.example.ejerciciodeportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonasController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaConDeporteDTO>> listarPersonasConDeportes(){
        List<PersonaConDeporteDTO> listaPersonasConDeporte = personaService.listarPersonas();
        return ResponseEntity.ok(listaPersonasConDeporte);
    }
}
