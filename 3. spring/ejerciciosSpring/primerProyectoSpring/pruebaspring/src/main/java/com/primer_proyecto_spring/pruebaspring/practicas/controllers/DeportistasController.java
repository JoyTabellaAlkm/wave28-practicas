package com.primer_proyecto_spring.pruebaspring.practicas.controllers;

import com.primer_proyecto_spring.pruebaspring.practicas.dto.DeporteDto;
import com.primer_proyecto_spring.pruebaspring.practicas.services.deportistasServices.IDeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {
    @Autowired
    IDeportistasService deportistasService;

    @GetMapping("/findSports")
    ResponseEntity<List<DeporteDto>> consultarDeportes (){
    return ResponseEntity.status(HttpStatus.OK).body(deportistasService.traerTodosDepoertes());
    }
}
