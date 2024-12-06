package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.DeportistaDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;
import com.bootcamp.deportistas.repository.DeporteRepository;
import com.bootcamp.deportistas.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeportistaService implements IDeportistaService {
    private final DeporteRepository deporteRepository;
    private final PersonaRepository personaRepository;

    public DeportistaService(DeporteRepository deporteRepository, PersonaRepository personaRepository) {
        this.deporteRepository = deporteRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    public List<DeporteDTO> findSports() {
        List<Deporte> sports = deporteRepository.getAll();
        return sports.stream().map(this::convertDeporteToDeporteDTO).toList();
    }

    @Override
    public Optional<DeporteDTO> findSportByName(String sportName) {
        Optional<Deporte> sport = deporteRepository.getByName(sportName);
        return sport.map(this::convertDeporteToDeporteDTO);
    }

    @Override
    public List<DeportistaDTO> findSportPersons() {
        List<Persona> people = personaRepository.getAll();
        return people.stream().map(this::convertPersonaToDeportistaDTO).toList();
    }

    private DeporteDTO convertDeporteToDeporteDTO(Deporte sport) {
        return new DeporteDTO(sport);
    }

    private DeportistaDTO convertPersonaToDeportistaDTO(Persona persona) {
        return new DeportistaDTO(persona);
    }
}