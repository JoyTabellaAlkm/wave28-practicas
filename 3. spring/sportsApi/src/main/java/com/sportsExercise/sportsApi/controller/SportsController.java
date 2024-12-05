package com.sportsExercise.sportsApi.controller;

import com.sportsExercise.sportsApi.DTO.PersonaDeportistaDTO;
import com.sportsExercise.sportsApi.entities.Deporte;
import com.sportsExercise.sportsApi.entities.Persona;
import com.sportsExercise.sportsApi.service.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sports")
public class SportsController {

    @Autowired
    ISportsService sportsService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return sportsService.findSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        return sportsService.findSport(name);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> findSportsPersons() {
        return sportsService.findSportsPersons();
    }


}
