package org.bootcampmeli.ejerciciodeportistas.controller;


import org.bootcampmeli.ejerciciodeportistas.dto.DeporteDTO;
import org.bootcampmeli.ejerciciodeportistas.dto.DeportistaDTO;
import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.model.Persona;
import org.bootcampmeli.ejerciciodeportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController


public class EjercicioController {
    @Autowired
    DeporteService deporteService;



    @GetMapping("/findSportPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<Persona> deportistas=  deporteService.findSportPersons();
        List<DeportistaDTO> deportistaDTOs = deportistas.stream().map(d -> new DeportistaDTO(d.getNombre(),d.getApellido(),d.getDeporte().getNombre())).toList();

        return new ResponseEntity<>(deportistaDTOs,HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name){
        Deporte deporte = deporteService.findSportByName(name);
        DeporteDTO deporteDTO = new DeporteDTO(deporte.getNombre(), deporte.getNivel());
        return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        List<Deporte> deportes = deporteService.findSports();
        List<DeporteDTO> deporteDTOS = deportes.stream().map(deporte -> new DeporteDTO(deporte.getNombre(),deporte.getNivel())).toList();
        return new ResponseEntity<>(deporteDTOS, HttpStatus.OK);
    }

}
