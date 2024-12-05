package com.melibootcamp.covid19.repositories;

import com.melibootcamp.covid19.entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {

    private List<Persona> personaList;

    public PersonaRepository() {
        personaList = new ArrayList<>();
        personaList.add(new Persona(1, "Juan", "Pérez", 35, List.of("Dolor muscular", "Fiebre")));
        personaList.add(new Persona(2, "María", "González", 28, List.of("Dolor de cabeza", "Migraña")));
        personaList.add(new Persona(3, "Carlos", "López", 42, List.of("Alergia estacional", "Congestión nasal")));
        personaList.add(new Persona(4, "Ana", "Martínez", 30, List.of("Dolor de espalda", "Fatiga")));
        personaList.add(new Persona(5, "Lucía", "Rodríguez", 25, List.of("Pérdida del gusto o del olfato", "Escalofríos"))); // COVID-related
        personaList.add(new Persona(6, "Pedro", "Gómez", 65, List.of("Dificultad para respirar"))); // COVID-related
        personaList.add(new Persona(7, "Elena", "Ramírez", 70, List.of())); // Sin síntomas
    }

    public List<Persona> devolverPersonas(){
        return personaList;
    }

}
