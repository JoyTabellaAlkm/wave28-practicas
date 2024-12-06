package com.mercadolibre.ejerciciodeportistas.service;

import com.mercadolibre.ejerciciodeportistas.dto.DeporteDTO;
import com.mercadolibre.ejerciciodeportistas.dto.DeportistaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeportistaServiceImpl implements IDeportistaService{



    private static List<DeporteDTO> sports = new ArrayList<>(){{
        add("Futbol");

    }}

    @Override
    public List<DeporteDTO> findSports() {
        return List.of();
    }

    @Override
    public Optional<DeporteDTO> findSportByName(String sportName) {
        return Optional.empty();
    }

    @Override
    public List<DeportistaDTO> findSportPersons() {
        return List.of();
    }
}
