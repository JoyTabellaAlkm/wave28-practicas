package com.bootcamp.deportistas.service.impl;

import com.bootcamp.deportistas.DTO.DeportistaDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;
import com.bootcamp.deportistas.service.IDeporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteServiceImpl implements IDeporteService {

    private static final List<Deporte> deportes = new ArrayList<>(){{
        add(new Deporte(1L,"futboll", 4));
        add(new Deporte(2L,"tenis", 5));
    }};


    private static final List<Persona> personas = new ArrayList<>(){{
        add(new Persona("Toby", "Campos", 18,deportes.get(0)));
        add(new Persona("Oliver", "Carvallo", 30,deportes.get(1)));
        add(new Persona("Noel", "Campos", 15,deportes.get(1)));
    }};

    @Override
    public List<Deporte> findAllSports() {
        return deportes;
    }

    @Override
    public ResponseEntity<String> findSportByName(String deporte) {

        for (Deporte d : deportes) {
            if (d.getNombre().equals(deporte)){
                return ResponseEntity.ok("nivel de deporte: " + d.getNivel());
            }
        }
        return ResponseEntity.status(404).body("deporte no encontrado");
    }

    @Override
    public List<DeportistaDTO> findSportsPerson() {
        List<DeportistaDTO> deportistaDTOSList = new ArrayList<>();
        for (Persona persona: personas) {
            String nombreCompleto = persona.getNombre() + " " + persona.getApellido();
            String deporte = persona.getDeporte().getNombre();
            DeportistaDTO deportistaDTO = new DeportistaDTO(nombreCompleto,deporte);
            deportistaDTOSList.add(deportistaDTO);
        }

        return deportistaDTOSList;
    }


}
