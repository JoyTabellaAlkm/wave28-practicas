package com.spring.ejercicios.service;

import com.spring.ejercicios.dto.PersonaDeportistaDTO;

import java.util.List;

public interface iDeporteService {
    public List<String> allSports();

    public String findSportByName(String name);

    public List<PersonaDeportistaDTO> findSportsPersons();
}
