package com.example.starwars.controller;


import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IStarWarsService;
import com.example.starwars.service.StarWarsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    @Autowired
    private IStarWarsService iStarWarsService;


    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonajesByName(@PathVariable String name){
        return new ResponseEntity(iStarWarsService.getPersonajesByName(name), HttpStatus.OK);
    }
}
