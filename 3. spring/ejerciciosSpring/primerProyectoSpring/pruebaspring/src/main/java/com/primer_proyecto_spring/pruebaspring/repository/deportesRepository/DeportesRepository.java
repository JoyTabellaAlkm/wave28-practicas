package com.primer_proyecto_spring.pruebaspring.repository.deportesRepository;

import com.primer_proyecto_spring.pruebaspring.entities.dto.DeporteDto;
import com.primer_proyecto_spring.pruebaspring.entities.dto.PersonaDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportesRepository {
    List<DeporteDto> listaDeportes = new ArrayList<>();
    List<PersonaDto> listaPersona = new ArrayList<>();

    // Constructor
    public DeportesRepository() {
        // Crear y agregar deportes de prueba
        listaDeportes.add(new DeporteDto("Futbol", "Equipo"));
        listaDeportes.add(new DeporteDto("Baloncesto", "Equipo"));
        listaDeportes.add(new DeporteDto("Tenis", "Individual"));
        listaDeportes.add(new DeporteDto("Natación", "Individual"));
        listaDeportes.add(new DeporteDto("Voleibol", "Equipo"));
    }

    // Getters y setters
    public List<DeporteDto> getListaDeportes() {
        return listaDeportes;
    }

    public void setListaDeportes(List<DeporteDto> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }

    public List<PersonaDto> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<PersonaDto> listaPersona) {
        this.listaPersona = listaPersona;
    }
}