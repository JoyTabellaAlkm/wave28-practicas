package com.primer_proyecto_spring.pruebaspring.services.deportistasServices.impl;

import com.primer_proyecto_spring.pruebaspring.entities.dto.DeporteDto;
import com.primer_proyecto_spring.pruebaspring.entities.dto.PersonaDto;
import com.primer_proyecto_spring.pruebaspring.repository.deportesRepository.DeportesRepository;
import com.primer_proyecto_spring.pruebaspring.services.deportistasServices.IDeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeportistasServiceImpl implements IDeportistasService {

    @Autowired
    DeportesRepository deportesRepository;

    @Override
    public List<DeporteDto> traerTodosDepoertes() {
        return deportesRepository.getListaDeportes();
    }

    @Override
    public Optional<DeporteDto> traerUnDeporte(String nombre) {
        return deportesRepository.getListaDeportes().stream()
                .filter(deporte -> deporte.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public List<PersonaDto> traerTodosPersonas() {
        return List.of();
    }
}
