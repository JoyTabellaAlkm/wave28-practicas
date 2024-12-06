package com.example.deportista.service;

import com.example.deportista.dto.request.DeporteDTO;
import com.example.deportista.repository.deporte.DeporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeporteServiceImpl implements IDeporteService{
    private DeporteRepository desportesRepository =  new DeporteRepository();

    @Override
    public List<DeporteDTO> buscarDeportes() {
        return desportesRepository.getDeportesDto();
    }

    @Override
    public DeporteDTO buscarDeporte(String name) {
        DeporteDTO deporte = new DeporteDTO();
        try {
            deporte = desportesRepository.getDeportesDto().stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst().orElseThrow(()-> new RuntimeException("Deporte no encontrado"));
        }catch (RuntimeException e){
            return null;
        }
        return deporte;
    }
}
