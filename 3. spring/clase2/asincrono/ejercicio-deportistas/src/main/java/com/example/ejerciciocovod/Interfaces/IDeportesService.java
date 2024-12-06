package com.example.ejerciciocovod.Interfaces;

import com.example.ejerciciocovod.Clases.Deporte;
import com.example.ejerciciocovod.Clases.PersonaDeportistaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IDeportesService {
    List<Deporte> traerDeportes();
    Optional<Deporte> traerDeporte(String name);
    List<PersonaDeportistaDTO> traerDeportistas();

}
