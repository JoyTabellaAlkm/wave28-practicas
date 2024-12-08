package com.example.deportes.service;

import com.example.deportes.dto.DeporteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDeporteService {
    String obtenerDeportePorNombre(String nombre);
    List<DeporteDTO> obtenerDeportes();
}
