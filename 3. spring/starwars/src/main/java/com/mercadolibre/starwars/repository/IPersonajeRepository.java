package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.model.Personaje;

import java.io.IOException;
import java.util.List;

public interface IPersonajeRepository {
     public List<Personaje> getAllPersonajes()throws IOException;
}
