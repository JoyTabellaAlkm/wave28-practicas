package com.mercadolibre.deportistas.repository;

import com.mercadolibre.deportistas.model.Persona;

import java.util.List;


public interface IDeportistaRepository {
    public List<Persona> getDeportistas();
}
