package com.example.ejerciciodeportistas.service;

import com.example.ejerciciodeportistas.model.Deporte;
import com.example.ejerciciodeportistas.model.Persona;
import com.example.ejerciciodeportistas.model.PersonaConDeporteDTO;
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

    public List<PersonaConDeporteDTO> listarPersonas(){
        List<PersonaConDeporteDTO> listaPersonasConDeporte = new ArrayList<>();

        for (Persona persona: listaPersonas) {
            String nombrePersona = persona.getNombre();
            String apellidoPersona = persona.getApellido();
            String nombreDeporte = persona.getDeporte().getNombre();
            PersonaConDeporteDTO personaConDeporte =new PersonaConDeporteDTO(nombrePersona,apellidoPersona, nombreDeporte);
            listaPersonasConDeporte.add(personaConDeporte);
        }
        return listaPersonasConDeporte;
    }

}
