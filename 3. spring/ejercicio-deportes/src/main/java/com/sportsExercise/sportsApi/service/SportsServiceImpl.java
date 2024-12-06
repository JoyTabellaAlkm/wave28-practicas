package com.sportsExercise.sportsApi.service;

import com.sportsExercise.sportsApi.DTO.PersonaDeportistaDTO;
import com.sportsExercise.sportsApi.entities.Deporte;
import com.sportsExercise.sportsApi.entities.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SportsServiceImpl implements ISportsService{

    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();


    public void peopleAdder() {
        deportes.add(new Deporte("Fútbol", "Profesional"));
        deportes.add(new Deporte("Baloncesto", "Intermedio"));

        personas.add(new Persona("Juan", "Pérez", 25, deportes.get(0)));
        personas.add(new Persona("Ana", "García", 30, deportes.get(1)));
    }

    @Override
    public ResponseEntity<List<Deporte>> findSports() {
        return ResponseEntity.ok(deportes);
    }

    @Override
    public ResponseEntity<List<PersonaDeportistaDTO>> findSportsPersons() {
        List<PersonaDeportistaDTO> deportistasDTO = new ArrayList<>();
        for (Persona persona : personas) {
            deportistasDTO.add(new PersonaDeportistaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()));
        }
        return ResponseEntity.ok(deportistasDTO);
    }

    @Override
    public ResponseEntity<String> findSport(String name) {
        for (Deporte deporte : deportes) {
            if (deporte.getNombre().equalsIgnoreCase(name)) {
                return ResponseEntity.ok("Nivel del deporte: " + deporte.getNivel());
            }
        }
        return ResponseEntity.notFound().build();
    }
}
