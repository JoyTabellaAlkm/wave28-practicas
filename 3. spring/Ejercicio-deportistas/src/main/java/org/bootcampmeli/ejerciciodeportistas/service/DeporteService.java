package org.bootcampmeli.ejerciciodeportistas.service;

import org.bootcampmeli.ejerciciodeportistas.dto.DeporteDTO;
import org.bootcampmeli.ejerciciodeportistas.dto.DeportistaDTO;
import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.repositories.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService implements IDeporteService {

    @Autowired
    DeporteRepository deporteRepository;


    public List<DeportistaDTO> findSportPersons() {
        return deporteRepository.findSportPersons();
    }

    public ResponseEntity<String> findSportByName(String name) {
        return new ResponseEntity<>(deporteRepository.findByName(name), HttpStatus.OK);
    }

    public List<DeporteDTO> findSports(){
        return deporteRepository.findSports();
    }



}
