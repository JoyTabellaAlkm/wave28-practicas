package com.bootcamp.deportistas.service.impl;

import com.bootcamp.deportistas.data.PersonaRepository;
import com.bootcamp.deportistas.model.Persona;
import com.bootcamp.deportistas.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Override
    public List<Persona> getDeportistas() {
        return PersonaRepository.DATA.stream()
                .filter(p -> p.getDeporte() != null)
                .toList();
    }
}
