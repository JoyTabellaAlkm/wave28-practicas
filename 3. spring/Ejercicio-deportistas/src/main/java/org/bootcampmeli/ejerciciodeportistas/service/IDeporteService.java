package org.bootcampmeli.ejerciciodeportistas.service;


import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.model.Persona;

import java.util.List;

public interface IDeporteService {

    List<Persona> findSportPersons();
    Deporte findSportByName(String name);
    List<Deporte> findSports();


}
