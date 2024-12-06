package com.bootcamp.ejerciciostarwars.repository;

import com.bootcamp.ejerciciostarwars.dto.PersonajeDto;
import com.bootcamp.ejerciciostarwars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getPersonajes();
}
