package com.mercadolibre.deportistas.service.impl;

import com.mercadolibre.deportistas.dto.DeporteDTO;
import com.mercadolibre.deportistas.dto.PersonaDeporteDTO;
import com.mercadolibre.deportistas.model.Deporte;
import com.mercadolibre.deportistas.model.Persona;
import com.mercadolibre.deportistas.repository.IDeporteRepository;
import com.mercadolibre.deportistas.repository.IDeportistaRepository;
import com.mercadolibre.deportistas.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteService implements IDeporteService {

    @Autowired
    private IDeporteRepository deporteRepository;

    @Autowired
    private IDeportistaRepository deportistaRepository;

    @Override
    public List<DeporteDTO> getSports() {
        List<Deporte> deportes = deporteRepository.getDeportes();
        return deportes.stream().map(d -> DeporteDTO.fromEntity(d)).toList();
    }

    @Override
    public Integer getSportByName(String name) {
        List<Deporte> deportes = deporteRepository.getDeportes();
        Optional<Deporte> deporte = deportes.stream()
                .filter(d -> d.getNombre().toLowerCase().contains(name.toLowerCase()))
                .findFirst();

        return deporte.isPresent() ? deporte.get().getNivel() : -1;
    }

    @Override
    public List<PersonaDeporteDTO> getSportsPersons() {
        List<Persona> personas = deportistaRepository.getDeportistas();
        return personas.stream().map(PersonaDeporteDTO::fromEntity).toList();
    }
}
