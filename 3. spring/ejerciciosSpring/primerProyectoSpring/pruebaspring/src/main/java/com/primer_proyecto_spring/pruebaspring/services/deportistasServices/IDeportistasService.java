package com.primer_proyecto_spring.pruebaspring.services.deportistasServices;

import com.primer_proyecto_spring.pruebaspring.entities.dto.DeporteDto;
import com.primer_proyecto_spring.pruebaspring.entities.dto.PersonaDto;

import java.util.List;
import java.util.Optional;

public interface IDeportistasService {
    public List<DeporteDto> traerTodosDepoertes();
    public Optional<DeporteDto> traerUnDeporte(String nombre);
    public List<PersonaDto> traerTodosPersonas ();
}
