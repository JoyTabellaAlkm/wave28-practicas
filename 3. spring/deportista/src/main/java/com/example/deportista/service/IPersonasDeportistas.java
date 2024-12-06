package com.example.deportista.service;

import com.example.deportista.dto.request.PersonaDTO;
import com.example.deportista.dto.request.PersonaDeportistaDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPersonasDeportistas {

    public List<PersonaDeportistaDTO> buscarPersonasDeportistas();
}
