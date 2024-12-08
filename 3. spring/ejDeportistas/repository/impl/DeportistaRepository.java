package com.mercadolibre.deportistas.repository.impl;

import com.mercadolibre.deportistas.model.Deporte;
import com.mercadolibre.deportistas.model.Persona;
import com.mercadolibre.deportistas.repository.IDeportistaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistaRepository implements IDeportistaRepository {

    private List<Persona> personas = new ArrayList<>();

    public DeportistaRepository() {
        Deporte basquet = new Deporte("basquet", 2);
        Deporte futbol = new Deporte("futbol", 1);
        Deporte tenis = new Deporte("tenis", 2);

        Persona persona1 = new Persona("guille", "kalniker", 25, basquet);
        Persona persona2 = new Persona("pepe", "argento", 63, tenis);
        Persona persona3 = new Persona("robert", "perez", 25, futbol);

        this.personas.add(persona1);
        this.personas.add(persona2);
        this.personas.add(persona3);
    }

    @Override
    public List<Persona> getDeportistas() {
        return personas;
    }
}
