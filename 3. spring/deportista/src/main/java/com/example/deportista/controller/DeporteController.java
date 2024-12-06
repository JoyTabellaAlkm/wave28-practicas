package com.example.deportista.controller;

import com.example.deportista.dto.request.DeporteDTO;
import com.example.deportista.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DeporteController {

    @Autowired
    private IDeporteService deporteService;

    @GetMapping("/findSports")
    ResponseEntity<?> findSports(){
        return new ResponseEntity<>(deporteService.buscarDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    ResponseEntity<?> findSportsWithName(@PathVariable String name){
        Optional<DeporteDTO> deporteOptional = Optional.ofNullable(deporteService.buscarDeporte(name));

        if (deporteOptional.isPresent()) {
            return ResponseEntity.ok(deporteOptional.get()+"pedro");
        } else {
            return new ResponseEntity<>("Deporte no encontrado",HttpStatus.BAD_REQUEST);
        }

    }
}
