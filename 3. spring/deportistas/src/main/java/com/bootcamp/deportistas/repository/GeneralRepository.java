package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.domain.Deporte;
import com.bootcamp.deportistas.domain.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GeneralRepository {
    private static final List<Deporte> listaDeportes = new ArrayList<>() {{
        add(new Deporte(1L, "Tenis", "Intermedio"));
        add(new Deporte(2L, "Fútbol", "Intermedio"));
        add(new Deporte(3L, "Boxeo", "Avanzado"));
        add(new Deporte(4L, "Natación", "Principiante"));
    }};

    private static final List<Persona> listaPersona = new ArrayList<>() {{
        add(new Persona(1L, "Lucas", "Caraballo", 21, listaDeportes.getFirst()));
        add(new Persona(1L, "Lisandro", "Alo", 20, listaDeportes.get(1)));
        add(new Persona(1L, "Gian", "Panigatti", 22, listaDeportes.get(2)));
    }};

    public List<Deporte> findAll() {
        return listaDeportes;
    }

    public Optional<Deporte> findByName(String name) {
        return listaDeportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Persona> findSportsPersons() {
        return listaPersona;
    }
}
