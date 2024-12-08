package com.mercadolibre.deportistas.repository;

import com.mercadolibre.deportistas.model.Deporte;

import java.util.List;

public interface IDeporteRepository {
    public List<Deporte> getDeportes();
}
