package com.example.starwars.service.imp;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.model.Personaje;
import com.example.starwars.repository.imp.PersonajeRepository;
import com.example.starwars.service.IPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements IPersonaje {

    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }


    @Override
    public List<PersonajeDTO> buscar(String nombre) {
        List<Personaje> personajes = personajeRepository.buscarPorNombre(nombre);
        return convertirModelADTO(personajes);
    }

    private List<PersonajeDTO> convertirModelADTO(List<Personaje> personajes){
        return personajes.stream().map(p-> new PersonajeDTO(p.getName(),p.getHeight(),p.getMass(),p.getGender(),p.getHomeworld(),p.getSpecies())).toList();
    }
}
