package com.bootcamp.ejercicio_deportistas.Services;

import com.bootcamp.ejercicio_deportistas.Dto.DeporteDto;

import java.util.List;

public interface IDeporteService {
    public List<DeporteDto> buscarDeportes();
    public String buscarNivelPorNombre(String nombre);
}
