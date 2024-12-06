package com.mercadolibre.covid19.service.impl;

import com.mercadolibre.covid19.dto.PersonaDTO;
import com.mercadolibre.covid19.dto.SintomaDTO;
import com.mercadolibre.covid19.dto.SintomaNombreDTO;
import com.mercadolibre.covid19.model.Persona;
import com.mercadolibre.covid19.model.Sintoma;
import com.mercadolibre.covid19.repository.CRUD;
import com.mercadolibre.covid19.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    CRUD<Persona> personaRepository;
    @Autowired
    CRUD<Sintoma> sintomaRepository;

    @Override
    public List<PersonaDTO> buscarPersonasDeRiesgo() {
        return personaRepository.buscar().stream()
                .filter(persona ->
                        persona.getEdad()>60&&
                                !persona.getSintomas().isEmpty())
                        .map(this::convertirModelDTO).toList();
    }

    private PersonaDTO convertirModelDTO(Persona persona){

        List<SintomaNombreDTO> listaNombreSintomas = persona.getSintomas().stream()
                .map(sintoma -> new SintomaNombreDTO(sintoma.getNombre()))
                .collect(Collectors.toList());
        return new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getEdad(),listaNombreSintomas);
    }

}
