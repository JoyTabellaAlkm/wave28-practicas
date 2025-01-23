package com.melibootcamp.sportsmen.controllers;

import com.melibootcamp.sportsmen.dtos.SportDto;
import com.melibootcamp.sportsmen.services.SportServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class SportController {

    private SportServiceImpl sportService;

    public SportController(SportServiceImpl sportServiceImpl){
        this.sportService = sportServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> getSports(){
        return new ResponseEntity<>(sportService.getSports(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getSportById(
            @PathVariable long id)
    {
        return new ResponseEntity<>(sportService.getSportById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> saveSport(
            @RequestBody SportDto sport)
    {
        return new ResponseEntity<>(sportService.saveSport(sport), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSport(
            @PathVariable long id)
    {
        return new ResponseEntity<>(sportService.deleteSport(id), HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateSport(
            @RequestBody SportDto sport, @PathVariable long id)
    {
        return new ResponseEntity<>(sportService.updateSport(id, sport), HttpStatus.OK);
    }
    
}
