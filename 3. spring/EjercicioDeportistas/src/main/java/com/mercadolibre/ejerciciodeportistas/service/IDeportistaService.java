package com.mercadolibre.ejerciciodeportistas.service;

import com.mercadolibre.ejerciciodeportistas.dto.DeporteDTO;
import com.mercadolibre.ejerciciodeportistas.dto.DeportistaDTO;
import com.mercadolibre.ejerciciodeportistas.dto.PersonaDTO;

import java.util.List;
import java.util.Optional;

public interface IDeportistaService {
    public List<DeporteDTO> findSports();

    public Optional<DeporteDTO> findSportByName(String sportName);

    public List<DeportistaDTO> findSportPersons();
}
