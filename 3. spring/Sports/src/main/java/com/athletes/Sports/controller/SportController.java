package com.athletes.Sports.controller;

import com.athletes.Sports.dto.PersonDto;
import com.athletes.Sports.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    @Autowired
    private ISportService sportsService;

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports() {
        return ResponseEntity.ok(sportsService.findAll());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name) {
        return ResponseEntity.ok(sportsService.findLevelBySportName(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDto>> findSportsPersons() {
        return ResponseEntity.ok(sportsService.getPersonSport());
    }
}
