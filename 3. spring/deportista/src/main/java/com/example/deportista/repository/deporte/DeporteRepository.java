package com.example.deportista.repository.deporte;

import com.example.deportista.dto.request.DeporteDTO;
import com.example.deportista.dto.request.PersonaDTO;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {
    private List<DeporteDTO> deportesDto;

    public DeporteRepository(){
        deportesDto = inicializarDeportes();
    }

    public ArrayList<DeporteDTO> inicializarDeportes() {
        ArrayList<DeporteDTO> deportes = new ArrayList<>();

                deportes.add(new DeporteDTO("Futbol", "Aficionado"));
                deportes.add(new DeporteDTO("Basketball", "Profesional"));
                deportes.add(new DeporteDTO("Natación", "Competitivo"));
                deportes.add(new DeporteDTO("Tenis", "Aficionado"));
                deportes.add(new DeporteDTO("Ciclismo", "Recreativo"));
                deportes.add(new DeporteDTO("Atletismo", "Profesional"));
                deportes.add(new DeporteDTO("Futbol", "Competitivo"));
                deportes.add(new DeporteDTO("Volleyball", "Aficionado"));

        return deportes;
    }

    public List<DeporteDTO> getDeportesDto() {
        return deportesDto;
    }

    public void setDeportesDto(List<DeporteDTO> deportesDto) {
        this.deportesDto = deportesDto;
    }
}
