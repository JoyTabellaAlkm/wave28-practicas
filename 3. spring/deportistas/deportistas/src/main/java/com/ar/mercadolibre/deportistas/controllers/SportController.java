package com.ar.mercadolibre.deportistas.controllers;

import com.ar.mercadolibre.deportistas.dtos.SportDTO;
import com.ar.mercadolibre.deportistas.services.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private ISportService service;

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports() {
        List<SportDTO> sports = service.findSports();

        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getLevelBySportName(@PathVariable String name) {
        String level = service.getLevelBySportName(name);

        if(level == null) return new ResponseEntity<>("No sport with that name", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(level, HttpStatus.OK);
    }

}
