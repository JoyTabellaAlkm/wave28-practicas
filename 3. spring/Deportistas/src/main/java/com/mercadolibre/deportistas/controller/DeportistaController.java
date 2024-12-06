package com.mercadolibre.deportistas.controller;

import com.mercadolibre.deportistas.service.IDeporteService;
import com.mercadolibre.deportistas.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeportistaController {
    @Autowired
    private IDeporteService deporteService;
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/buscarDeportes")
    public ResponseEntity<?> obtenerDeportes(){
        return new ResponseEntity<>(deporteService.buscarDeportes(), HttpStatus.OK);
    }

    @GetMapping("/buscarDeporte/{nombre}")
    public ResponseEntity<?> obtenerDeporte(@PathVariable String nombre){
        return new ResponseEntity<>(deporteService.buscarDeportePorNombre(nombre)
        ,HttpStatus.OK);
    }

    @GetMapping("/buscarPersonasDeportistas")
    public ResponseEntity<?> obtenerDeportistas(){
        return new ResponseEntity<>(
                personaService.devolverDeportistas(),
                HttpStatus.OK
        );
    }
}
