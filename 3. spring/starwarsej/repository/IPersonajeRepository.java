package com.mercadolibre.starwarsej.repository;

import com.mercadolibre.starwarsej.model.Personaje;

import java.util.List;

public interface IPersonajeRepository{
    public List<Personaje> loadPersonajes();
}
