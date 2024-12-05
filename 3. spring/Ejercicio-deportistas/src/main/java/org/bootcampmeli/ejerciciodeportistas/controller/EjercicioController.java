package org.bootcampmeli.ejerciciodeportistas.controller;


import org.bootcampmeli.ejerciciodeportistas.dto.DeportistaDTO;
import org.bootcampmeli.ejerciciodeportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController


public class EjercicioController {
    @Autowired
    DeporteService deporteService;



    @GetMapping("/findSportPersons")
    public String findSportsPersons() {

        return deporteService.findSportPersons().toString();

    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        return deporteService.findSportByName(name);
    }

    @GetMapping("/findSports")
    public String findSports(){
        return deporteService.findSports().toString();

    }

}
