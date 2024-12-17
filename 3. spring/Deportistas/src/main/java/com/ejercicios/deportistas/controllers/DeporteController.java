package com.ejercicios.deportistas.controllers;

import com.ejercicios.deportistas.dto.DeporteDTO;
import com.ejercicios.deportistas.dto.responses.DeportesYPersonasResponse;
import com.ejercicios.deportistas.services.IDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeporteController {

    @Autowired
    private IDeporte deporte;


    @GetMapping("/findSports")
    public List<DeporteDTO> findSports(){
        return deporte.listaDeportes();
    }

    @GetMapping("/findSport")
    public ResponseEntity<DeporteDTO> findSportByName(@RequestParam String nombre){

        return new ResponseEntity<DeporteDTO>(deporte.encontrarDeporte(nombre), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSportsPeople")
    public ResponseEntity<?> findSportsPeople(){
        return new ResponseEntity<List<DeportesYPersonasResponse>>(deporte.encontrarDeportesPersonas(),HttpStatus.ACCEPTED);
    }
}