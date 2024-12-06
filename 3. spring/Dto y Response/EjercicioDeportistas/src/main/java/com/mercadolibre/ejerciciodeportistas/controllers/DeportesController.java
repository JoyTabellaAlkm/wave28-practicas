package com.mercadolibre.ejerciciodeportistas.controllers;

import com.mercadolibre.ejerciciodeportistas.request.DeportesDTO;
import com.mercadolibre.ejerciciodeportistas.response.DeportesDTOResponse;
import com.mercadolibre.ejerciciodeportistas.response.PersonaDTOResponse;
import com.mercadolibre.ejerciciodeportistas.services.IDeportes;
import com.mercadolibre.ejerciciodeportistas.services.IPersonas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeportesController {

    @Autowired
    private IDeportes deportesService;
    @Autowired
    private IPersonas personasService;

//    http://localhost:8080/findSports
    @GetMapping("/findSports")
    public ResponseEntity<List<DeportesDTOResponse>> encontrarDeportes(){
        return ResponseEntity.ok(deportesService.devolverDeportes());
    }

//    http://localhost:8080/createSports
    @PostMapping("/createSports")
    public ResponseEntity<DeportesDTOResponse> crearDeportes(@RequestBody DeportesDTO deporte){
        DeportesDTOResponse nuevoDeporte = deportesService.crearDeporte(deporte);
        return ResponseEntity.ok(nuevoDeporte);
    }

//    http://localhost:8080/findSport/Ciclismo
    @GetMapping("/findSport/{deporte}")
    public ResponseEntity<DeportesDTOResponse> consultarDeporte(@PathVariable String deporte){
        DeportesDTOResponse deporteConsultado = deportesService.devolverDeporte(deporte);
        return ResponseEntity.ok(deporteConsultado);
    }

    @GetMapping("/findSportsPersonas")
    public ResponseEntity<List<PersonaDTOResponse>> devolverPersonas(){
        return ResponseEntity.ok(personasService.devolverPersonas());
    }

}

