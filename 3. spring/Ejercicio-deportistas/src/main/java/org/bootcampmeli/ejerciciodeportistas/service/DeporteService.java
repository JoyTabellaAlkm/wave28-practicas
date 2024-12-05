package org.bootcampmeli.ejerciciodeportistas.service;

import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.model.Persona;
import org.bootcampmeli.ejerciciodeportistas.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteService implements IDeporteService {

    @Autowired
    Repository repository;



    public List<Persona> findSportPersons() {
        return repository.findAllPersonas();
    }

    public Optional<Deporte> findSportByName(String name) {
        return Optional.ofNullable(repository.findByName(name));
    }

    public List<Deporte> findSports(){
        return repository.findAllDeportes();
    }



}
