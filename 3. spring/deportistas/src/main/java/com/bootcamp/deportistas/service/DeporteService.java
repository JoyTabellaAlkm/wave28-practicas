package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.model.Deporte;

import java.util.List;
import java.util.Optional;

public interface DeporteService {
    List<Deporte> getAllDeportes();
    Optional<Deporte> findBy(String nombre);
}
