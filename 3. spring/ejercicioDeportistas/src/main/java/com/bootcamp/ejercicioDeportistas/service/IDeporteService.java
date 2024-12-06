package com.bootcamp.ejercicioDeportistas.service;

import com.bootcamp.ejercicioDeportistas.model.Deporte;

import java.util.Optional;

public interface IDeporteService {
    String getDeportes();

    Optional<String> getDeportesByName(String name);
}
