package com.example.deportista.service;

import com.example.deportista.dto.request.DeporteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDeporteService {
    public List<DeporteDTO> buscarDeportes();
    public DeporteDTO buscarDeporte(String name);
}
