package com.sportsExercise.sportsApi.service;

import com.sportsExercise.sportsApi.DTO.PersonaDeportistaDTO;
import com.sportsExercise.sportsApi.entities.Deporte;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ISportsService {
    public ResponseEntity<List<Deporte>> findSports();
    public ResponseEntity<String> findSport(String name);
    public ResponseEntity<List<PersonaDeportistaDTO>> findSportsPersons();
}
