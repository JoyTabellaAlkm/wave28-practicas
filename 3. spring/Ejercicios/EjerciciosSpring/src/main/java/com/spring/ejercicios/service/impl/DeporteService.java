package com.spring.ejercicios.service.impl;

import com.spring.ejercicios.dto.PersonaDeportistaDTO;
import com.spring.ejercicios.model.Deporte;
import com.spring.ejercicios.model.PersonaDerportista;
import com.spring.ejercicios.service.iDeporteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteService implements iDeporteService {

    private List<Deporte> deportes = List.of(
            new Deporte("Futbol", "principiante"),
            new Deporte("Tenis", "avanzado")
            );
    private List<PersonaDerportista> personas = List.of(
            new PersonaDerportista("caro", "sch", 27, deportes.get(0)),
            new PersonaDerportista("nico", "sch", 30, deportes.get(1))
    );


    @Override
    public List<String> allSports() {
        return deportes.stream().map(Deporte::getNombre).toList();
    }

    @Override
    public String findSportByName(String name) {
        Deporte aux =  deportes.stream().filter(x -> x.getNombre().equals(name)).findFirst().orElse(null);
        String res = "Deporte no encontrado";
        if (aux != null){
            res = "El deporte " + name + " tiene como nivel de dificultad " + aux.getNivel();
        }
        return res;
    }

    @Override
    public List<PersonaDeportistaDTO> findSportsPersons() {
        List<PersonaDeportistaDTO> personaLista = new ArrayList<>();
        for (PersonaDerportista p : personas){
            personaLista.add(new PersonaDeportistaDTO(p.getNombre(),p.getApellido(),p.getDeporte().getNombre()));
        }
        return personaLista;
    }
}
