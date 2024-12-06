package com.example.deportista.repository.cliente;

import com.example.deportista.dto.request.DeporteDTO;
import com.example.deportista.dto.request.PersonaDTO;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<PersonaDTO> personaDTOList;

    public ClienteRepository(){
        personaDTOList = inicializarLista();
    }

    private List<PersonaDTO> inicializarLista(){
        List<PersonaDTO> personas = List.of(
                new PersonaDTO("Juan", "Perez", 26, new DeporteDTO("Futbol", "Aficionado")),
                new PersonaDTO("Maria", "Gomez", 30, new DeporteDTO("Basketball", "Profesional")),
                new PersonaDTO("Luis", "Martinez", 22, new DeporteDTO("Natación", "Competitivo")),
                new PersonaDTO("Ana", "Lopez", 28, new DeporteDTO("Tenis", "Aficionado")),
                new PersonaDTO("Pedro", "Garcia", 34, new DeporteDTO("Ciclismo", "Recreativo")),
                new PersonaDTO("Laura", "Diaz", 19, new DeporteDTO("Atletismo", "Profesional")),
                new PersonaDTO("Diego", "Moreno", 40, new DeporteDTO("Futbol", "Competitivo")),
                new PersonaDTO("Elena", "Torres", 25, new DeporteDTO("Volleyball", "Aficionado"))
        );

        return personas;
    }

    public List<PersonaDTO> getPersonaDTOList() {
        return personaDTOList;
    }

    public void setPersonaDTOList(List<PersonaDTO> personaDTOList) {
        this.personaDTOList = personaDTOList;
    }
}
