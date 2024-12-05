package com.melibootcamp.covid19.controllers;

import com.melibootcamp.covid19.dtos.PersonaDeRiesgoDTO;
import com.melibootcamp.covid19.entities.Sintoma;
import com.melibootcamp.covid19.services.Covid19Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/corona")
public class Covid19Controller {

    private Covid19Service covid19Service;

    public Covid19Controller(){
        this.covid19Service = new Covid19Service();
    }

    @GetMapping
    @RequestMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> obtenerSintomas(){
        return new ResponseEntity<>(covid19Service.obtenerSintomasCargados(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/findSymptom/{name}")
    public ResponseEntity<Integer> obtenerNivelDeGravedadSintomaPorNombre(@PathVariable("name") String name){
        int toReturn = covid19Service.obtenerGravedadDeSintomaPorNombre(name);
        switch (toReturn){
            case -1:
                return new ResponseEntity<>(toReturn, HttpStatus.BAD_REQUEST);
            case 0:
                return new ResponseEntity<>(toReturn, HttpStatus.INTERNAL_SERVER_ERROR);
            default:
                return new ResponseEntity<>(toReturn, HttpStatus.OK);
        }
    }

    @GetMapping
    @RequestMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDeRiesgoDTO>> obtenerPersonasDeRiesgo(){
        return new ResponseEntity<>(covid19Service.obtenerPersonasDeRiesgo(), HttpStatus.OK);
    }









}
