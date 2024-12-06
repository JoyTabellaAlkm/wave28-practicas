package com.example.ejerciciocovod.Services;

import com.example.ejerciciocovod.Clases.Deporte;
import com.example.ejerciciocovod.Clases.Persona;
import com.example.ejerciciocovod.Clases.PersonaDeportistaDTO;
import com.example.ejerciciocovod.Interfaces.IDeportesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeportesServiceImpl implements IDeportesService {
    Deporte deporte1 = new Deporte("Voley",2);
    Deporte deporte2 = new Deporte("Futbol",2);
    Deporte deporte3 = new Deporte("Basketball",2);
    Deporte deporte4 = new Deporte("Ski",3);
    Deporte deporte5 = new Deporte("Ping Pong",1);

    List<Deporte> deportes = new ArrayList<Deporte>(List.of(deporte1,deporte2,deporte3,deporte4,deporte5));

    Persona persona1 = new Persona("Paloma","Sosa",24,deporte1);
    Persona persona2 = new Persona("Melania","Simes",32,null);
    Persona persona3 = new Persona("Mateo","Ferrands",24,null);

    List<Persona> personas = new ArrayList<Persona>(List.of(persona1,persona2));
    @Override
    public List<Deporte> traerDeportes() {
        return deportes;
    }

    @Override
    public Optional<Deporte> traerDeporte(String name) {
        Optional<Deporte> deporteEncontrado = deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst();
        return deporteEncontrado;
    }
    @Override
    public List<PersonaDeportistaDTO> traerDeportistas() {
        List<PersonaDeportistaDTO> personasDeportistas = new ArrayList<PersonaDeportistaDTO>();
        for (Persona p:personas) {
            if (p.getDeporte() != null){
                PersonaDeportistaDTO personaDeportistaDTO = new PersonaDeportistaDTO(p.getNombre() + " " + p.getApellido(), p.getDeporte().getNombre());
                personasDeportistas.add(personaDeportistaDTO);
            }
        }
        return personasDeportistas;
    }
}
