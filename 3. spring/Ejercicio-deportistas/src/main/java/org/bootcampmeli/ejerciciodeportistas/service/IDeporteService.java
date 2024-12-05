package org.bootcampmeli.ejerciciodeportistas.service;


import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.model.Persona;

import java.util.List;
import java.util.Optional;

public interface IDeporteService {

    List<Persona> findSportPersons();
    Optional<Deporte> findSportByName(String name);
    List<Deporte> findSports();


}
