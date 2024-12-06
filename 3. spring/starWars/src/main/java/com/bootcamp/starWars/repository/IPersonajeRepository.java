package com.bootcamp.starWars.repository;

import com.bootcamp.starWars.model.Personaje;

import java.io.IOException;
import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> getAllPersonajes() throws IOException;
}
