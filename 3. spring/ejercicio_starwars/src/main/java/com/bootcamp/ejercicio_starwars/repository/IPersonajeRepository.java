package com.bootcamp.ejercicio_starwars.repository;

import com.bootcamp.ejercicio_starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> getPersonajesPorNombre(String nombre);
}
