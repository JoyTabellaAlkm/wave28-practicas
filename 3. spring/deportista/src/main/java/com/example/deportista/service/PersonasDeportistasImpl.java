package com.example.deportista.service;

import com.example.deportista.dto.request.PersonaDTO;
import com.example.deportista.dto.request.PersonaDeportistaDTO;
import com.example.deportista.repository.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonasDeportistasImpl implements IPersonasDeportistas{

    private ClienteRepository repositoryPersonasDeportistas = new ClienteRepository();

    @Override
    public List<PersonaDeportistaDTO> buscarPersonasDeportistas() {
        List<PersonaDeportistaDTO> personasDeportistas = new ArrayList<>();

        repositoryPersonasDeportistas.getPersonaDTOList().forEach( persona -> {
            PersonaDeportistaDTO personaDeportista = new PersonaDeportistaDTO();

            personaDeportista.setFullname(persona.getName() + " " + persona.getLastName());
            personaDeportista.setDeporte(persona.getDeporteDto().getName());
            personasDeportistas.add(personaDeportista);

                }
        );


        return personasDeportistas;
    }
}
