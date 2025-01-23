package com.deportistas.controller;

import com.deportistas.dto.SportDto;
import com.deportistas.dto.SportLevelDto;
import com.deportistas.dto.SportPersonDto;
import com.deportistas.service.ISportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    private final ISportService sportService;

    public SportController(ISportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> findSports() {
        return ResponseEntity.ok(sportService.findSports());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<SportLevelDto> findSportByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(sportService.findSport(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDto>> findSportPersons() {
        return ResponseEntity.ok(sportService.findSportPersons());
    }
}
