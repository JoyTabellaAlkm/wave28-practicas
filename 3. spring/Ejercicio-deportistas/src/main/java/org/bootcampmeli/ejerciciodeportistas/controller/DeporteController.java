package org.bootcampmeli.ejerciciodeportistas.controller;


import org.bootcampmeli.ejerciciodeportistas.dto.DeporteDTO;
import org.bootcampmeli.ejerciciodeportistas.dto.DeportistaDTO;
import org.bootcampmeli.ejerciciodeportistas.mapper.DeporteMapper;
import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.model.Persona;
import org.bootcampmeli.ejerciciodeportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController


public class DeporteController {
    @Autowired
    DeporteService deporteService;



    @GetMapping("/findSportPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<Persona> deportistas=  deporteService.findSportPersons();
        List<DeportistaDTO> deportistaDTOs = deportistas.stream().map(Persona::toDTO).toList();

        return new ResponseEntity<>(deportistaDTOs,HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name){
        Optional<Deporte> deporte = deporteService.findSportByName(name);
        if (deporte.isPresent()) {
            DeporteDTO deporteDTO = deporte.get().toDTO();
            return new ResponseEntity<>(deporteDTO,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        List<Deporte> deportes = deporteService.findSports();
        List<DeporteDTO> deporteDTOS = deportes.stream().map(Deporte::toDTO).toList();
        return new ResponseEntity<>(deporteDTOS, HttpStatus.OK);
    }

    @PostMapping("/addDeporte")
    public ResponseEntity addDeporte(DeporteDTO deporteDTO) {
        Deporte deporte = DeporteMapper.mapToDeporte(deporteDTO);
        return deporteService.addDeporte(deporte);
    }

}
