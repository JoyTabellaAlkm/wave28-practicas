package com.mercadolibre.ejerciciodeportistas.controller;

import com.mercadolibre.ejerciciodeportistas.model.PersonaConDeporteDTO;
import com.mercadolibre.ejerciciodeportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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