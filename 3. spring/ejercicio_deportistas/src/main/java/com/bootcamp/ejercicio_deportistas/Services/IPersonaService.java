package com.bootcamp.ejercicio_deportistas.Services;

import com.bootcamp.ejercicio_deportistas.Dto.DeportePersonaDto;

import java.util.List;

public interface IPersonaService {
    public List<DeportePersonaDto> buscarPersonasConDeportes();
}
