package com.mercadolibre.ejerciciodeportistas.service;

import com.mercadolibre.ejerciciodeportistas.model.Deporte;
import com.mercadolibre.ejerciciodeportistas.model.Persona;
import com.mercadolibre.ejerciciodeportistas.model.PersonaConDeporteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    List<Persona> listaPersonas = new ArrayList<>(List.of(
            new Persona("Santiago", "Baron", 24, new Deporte("Futbol", "avanzado")),
            new Persona("Leandro", "Tucu", 24, new Deporte("Baloncesto", "intermedio")),
            new Persona("Ariel", "Taca", 24, new Deporte("Atletismo", "principiante"))
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
