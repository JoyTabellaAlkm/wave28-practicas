package com.example.Ejercicio_StarWars.service.impl;

import com.example.Ejercicio_StarWars.dto.PersonajeDto;
import com.example.Ejercicio_StarWars.model.Personaje;
import com.example.Ejercicio_StarWars.repository.IPersonajeRepository;
import com.example.Ejercicio_StarWars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonajeServiceImpl implements IPersonajeService {
    @Autowired
    private final IPersonajeRepository repository;

    public PersonajeServiceImpl(IPersonajeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PersonajeDto> listarDto(String toFind) {
        List<Personaje> toRead = repository.listar();
        List<PersonajeDto> toReturn = new ArrayList<>();
        toRead.stream().filter(x -> x.getName().contains(toFind)).toList().stream().forEach(p ->
        toReturn.add(mapeaAPersonajeDto(p)));
        toRead.stream().forEach(System.out::println);
        return toReturn;
}

private PersonajeDto mapeaAPersonajeDto(Personaje p){
    return new PersonajeDto(p.getName(),p.getHeight(),p.getMass(),p.getGender(),p.getHomeworld(),p.getSpecies());
}




}
