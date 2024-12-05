package org.bootcampmeli.ejerciciodeportistas.service;


import org.bootcampmeli.ejerciciodeportistas.dto.DeporteDTO;
import org.bootcampmeli.ejerciciodeportistas.dto.DeportistaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDeporteService {

    List<DeportistaDTO> findSportPersons();
    ResponseEntity<String> findSportByName(String name);
    List<DeporteDTO> findSports();


}
