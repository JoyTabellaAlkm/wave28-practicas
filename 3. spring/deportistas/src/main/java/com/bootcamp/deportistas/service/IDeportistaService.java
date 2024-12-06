package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.DeportistaDTO;

import java.util.List;
import java.util.Optional;

public interface IDeportistaService {
    List<DeporteDTO> findSports();

    Optional<DeporteDTO> findSportByName(String sportName);

    List<DeportistaDTO> findSportPersons();
}