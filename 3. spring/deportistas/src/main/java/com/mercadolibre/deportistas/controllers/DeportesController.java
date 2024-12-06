package com.mercadolibre.deportistas.controllers;

import com.mercadolibre.deportistas.dto.DeporteDTO;
import com.mercadolibre.deportistas.dto.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportesController {
    private static List<DeporteDTO> deportes;
    private static List<PersonaDTO> personas;

    static {
        personas = new ArrayList<>();
        deportes = new ArrayList<>();
        deportes.add(new DeporteDTO("tennis","principiante"));
        deportes.add(new DeporteDTO("futbol","avanzado"));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        return new ResponseEntity(deportes, HttpStatus.OK);
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String name){
        DeporteDTO deporte = deportes.stream().filter(d->d.getNombre().equals(name)).findFirst().orElse(null);
        return new ResponseEntity(deporte, HttpStatus.OK);
    }

}
