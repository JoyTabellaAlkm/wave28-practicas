package com.bootcamp.ejercicio_deportistas.Services.Impl;

import com.bootcamp.ejercicio_deportistas.Dto.DeporteDto;
import com.bootcamp.ejercicio_deportistas.Repositories.IDeporteRepository;
import com.bootcamp.ejercicio_deportistas.Services.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService implements IDeporteService {

    @Autowired
    private IDeporteRepository deporteRepository;

    @Override
    public List<DeporteDto> buscarDeportes() {
        return deporteRepository.
                buscartodos().
                stream().
                map(deporte -> new DeporteDto(deporte.getNombre(), deporte.getNivel())).toList();
    }

    @Override
    public String buscarNivelPorNombre(String nombre) {
        return deporteRepository.buscarPorNombre(nombre).getNivel();
    }
}
