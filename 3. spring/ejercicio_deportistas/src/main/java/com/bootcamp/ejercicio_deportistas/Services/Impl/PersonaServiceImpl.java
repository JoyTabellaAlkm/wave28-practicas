package com.bootcamp.ejercicio_deportistas.Services.Impl;

import com.bootcamp.ejercicio_deportistas.Dto.DeportePersonaDto;
import com.bootcamp.ejercicio_deportistas.Models.Persona;
import com.bootcamp.ejercicio_deportistas.Repositories.IPersonaRepository;
import com.bootcamp.ejercicio_deportistas.Services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private IPersonaRepository personaRepository;


    @Override
    public List<DeportePersonaDto> buscarPersonasConDeportes() {
        List<Persona> personaList = personaRepository.buscartodos();
        List<DeportePersonaDto> deportePersona = new ArrayList<>();
        personaList.forEach(persona -> {
            deportePersona.add(new DeportePersonaDto(persona.getNombre(),
                    persona.getApellido(), persona.getDeporte().getNombre()));
        });
            return deportePersona;
        }
    }
