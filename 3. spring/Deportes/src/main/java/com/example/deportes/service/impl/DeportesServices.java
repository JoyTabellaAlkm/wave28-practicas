package com.example.deportes.service.impl;

import com.example.deportes.dto.DeporteDTO;
import com.example.deportes.service.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportesServices implements IDeporteService {

    List<DeporteDTO> deportes = new ArrayList<>();

    @Override
    public String obtenerDeportePorNombre(String nombre) {

        return "";
    }

    @Override
    public List<DeporteDTO> obtenerDeportes() {
        return List.of();
    }
}
