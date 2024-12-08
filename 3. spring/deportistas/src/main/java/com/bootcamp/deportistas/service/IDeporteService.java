package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.DTO.DeportistaDTO;
import com.bootcamp.deportistas.model.Deporte;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IDeporteService {

    public List<Deporte> findAllSports();

    public ResponseEntity<String> findSportByName(String name);

    public List<DeportistaDTO> findSportsPerson();
}
