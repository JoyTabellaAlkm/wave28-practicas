package com.meli.deportista.controller;

import com.meli.deportista.dto.DeporteDto;
import com.meli.deportista.dto.responses.DeportesYPersonasResponse;
import com.meli.deportista.entity.IDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeporteController {

    @Autowired
    private IDeporte deporte;


    @GetMapping("/findSports")
    public List<DeporteDto> findSports(){
        return deporte.listaDeportes();
    }

    @GetMapping("/findSport")
    public ResponseEntity<DeporteDto> findSportByName(@RequestParam String nombre){

        return new ResponseEntity<DeporteDto>(deporte.encontrarDeporte(nombre),HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSportsPeople")
    public ResponseEntity<?> findSportsPeople(){
        return new ResponseEntity<List<DeportesYPersonasResponse>>(deporte.encontrarDeportesPersonas(),HttpStatus.ACCEPTED);
    }
}