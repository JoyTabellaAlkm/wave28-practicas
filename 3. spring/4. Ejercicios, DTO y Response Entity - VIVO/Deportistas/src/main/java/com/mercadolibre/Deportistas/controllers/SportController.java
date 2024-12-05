package com.mercadolibre.Deportistas.controllers;

import com.mercadolibre.Deportistas.services.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sports/")
public class SportController {
    @Autowired
    private ISportService sportService;

    @GetMapping("/findSports/")
    public ResponseEntity<?> getAllSports(){
        return new ResponseEntity<>(sportService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(sportService.findSportByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons/")
    public ResponseEntity<?> findSportsPersons(){
        return new ResponseEntity<>(sportService.findSportsPersons(), HttpStatus.OK);
    }
}
