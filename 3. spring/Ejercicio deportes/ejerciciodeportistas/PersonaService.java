package com.example.ejerciciodeportistas;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    List<Persona> listaPersonas = new ArrayList<>(List.of(
            new Persona("Lucas", "Bianchi", 24, new Deporte("Ping pong", "avanzado")),
            new Persona("Joaquin", "Seita", 24, new Deporte("fútbol", "intermedio")),
            new Persona("Gian", "Pani", 24, new Deporte("tenis", "principiante"))
    ));

    public List<Persona> listarPersonas(){
        return listaPersonas;
    }

}
