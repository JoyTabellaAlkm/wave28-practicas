package com.mercadolibre.kartsrelaciones.controller;

import com.mercadolibre.kartsrelaciones.dto.RaceDTO;
import com.mercadolibre.kartsrelaciones.entity.Race;
import com.mercadolibre.kartsrelaciones.service.IRaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {

    private final IRaceService raceService;

    public RaceController(IRaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping
    public ResponseEntity<Long> createRace(@RequestBody RaceDTO race) {
        return new ResponseEntity<>(raceService.createRace(race),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RaceDTO>> getAllRaces() {
        return new ResponseEntity<>(raceService.getAllRaces(),HttpStatus.OK);
    }
}