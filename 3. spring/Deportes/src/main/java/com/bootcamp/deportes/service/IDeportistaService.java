package com.bootcamp.deportes.service;

import com.bootcamp.deportes.dto.DeporteDTO;
import com.bootcamp.deportes.dto.DeportistaDTO;

import java.util.List;
import java.util.Optional;

public interface IDeportistaService {
    List<DeporteDTO> findSports();

    Optional<DeporteDTO> findSportByName(String sportName);

    List<DeportistaDTO> findSportPersons();
}