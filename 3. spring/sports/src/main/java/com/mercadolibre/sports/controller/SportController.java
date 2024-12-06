package com.mercadolibre.sports.controller;

import com.mercadolibre.sports.service.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportController {

    @Autowired
    private ISportsService sportsService;

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports() {
        return ResponseEntity.ok(sportsService.findAll());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name) {
        return ResponseEntity.ok(sportsService.findLevelBySportName(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons() {
        return ResponseEntity.ok("");
    }

}
