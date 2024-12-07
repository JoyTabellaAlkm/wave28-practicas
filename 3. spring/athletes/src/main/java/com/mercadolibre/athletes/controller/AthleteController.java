package com.mercadolibre.athletes.controller;

import com.mercadolibre.athletes.dto.response.AthleteDTO;
import com.mercadolibre.athletes.dto.response.SportDTO;
import com.mercadolibre.athletes.service.AthleteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AthleteController {
    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> findAllSports(){
        return new ResponseEntity<>(athleteService.findAllSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportDTO> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(athleteService.findSportByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<AthleteDTO>> findSportPersons(){
        return new ResponseEntity<>(athleteService.findSportPersons(), HttpStatus.OK);
    }
}
