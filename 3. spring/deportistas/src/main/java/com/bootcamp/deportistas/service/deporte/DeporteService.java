package com.bootcamp.deportistas.service.deporte;

import com.bootcamp.deportistas.domain.Deporte;
import com.bootcamp.deportistas.domain.Persona;

import java.util.List;
import java.util.Optional;

public interface DeporteService {
    List<Deporte> findAll();
    Optional<Deporte> findByName(String name);
    List<Persona> findSportPersons();
}