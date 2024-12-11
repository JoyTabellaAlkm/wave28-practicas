package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAll();
}
