package com.demo.demo.service;

import com.demo.demo.dto.PersonajeDTO;
import com.demo.demo.repository.PersonajeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonajeService implements IPersonaje {

    @Autowired
    private PersonajeRepository repositorio;

    @Override
    public List<PersonajeDTO> buscarPersonaje(String nombre) {
        return this.repositorio.getPersonajes(nombre);
    }
}
