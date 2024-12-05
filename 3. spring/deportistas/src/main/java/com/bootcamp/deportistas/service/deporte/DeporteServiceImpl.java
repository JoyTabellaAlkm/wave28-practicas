package com.bootcamp.deportistas.service.deporte;

import com.bootcamp.deportistas.domain.Deporte;
import com.bootcamp.deportistas.domain.Persona;
import com.bootcamp.deportistas.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteServiceImpl implements DeporteService{
    @Autowired
    private GeneralRepository generalRepository;

    @Override
    public List<Deporte> findAll() {
        return generalRepository.findAll();
    }

    @Override
    public Optional<Deporte> findByName(String name) {
        return generalRepository.findByName(name);
    }

    @Override
    public List<Persona> findSportPersons() {
        return generalRepository.findSportsPersons();
    }
}
