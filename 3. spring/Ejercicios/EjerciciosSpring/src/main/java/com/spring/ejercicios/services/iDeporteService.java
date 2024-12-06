package com.spring.ejercicios.services;

import com.spring.ejercicios.dto.PersonaDeportistaDTO;

import java.util.List;

public interface iDeporteService {
    public List<String> allSports();

    public String findSportByName(String name);

    public List<PersonaDeportistaDTO> findSportsPersons();
}
