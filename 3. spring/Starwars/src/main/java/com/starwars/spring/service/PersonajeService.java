package com.starwars.spring.service;

import com.starwars.spring.dto.PersonajeDTO;
import com.starwars.spring.repository.IPersonajeRepository;
import com.starwars.spring.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {

    private IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        System.out.println("Se esta inicializando el service.");
        this.personajeRepository = personajeRepository;
    }


    @Override
    public ArrayList<PersonajeDTO> findByName(String name) {

        if(name.trim().isEmpty())
            return new ArrayList<>();

        var listPersonajes = this.personajeRepository.findByName(name);

        return listPersonajes.stream()
                .map(p->{
                    return new PersonajeDTO(
                            p.getId(),
                            p.getName(),
                            p.getHeight(),
                            p.getMass(),
                            p.getGender(),
                            p.getHomeworld(),
                            p.getSpecies()
                    );
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
