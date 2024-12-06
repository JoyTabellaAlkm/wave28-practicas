package com.mercadolibre.ejerciciodeportistas.services;

import com.mercadolibre.ejerciciodeportistas.request.DeportesDTO;
import com.mercadolibre.ejerciciodeportistas.response.DeportesDTOResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportesImpl implements IDeportes{

    List<DeportesDTOResponse> deportes = new ArrayList<>(List.of(
            new DeportesDTOResponse("Ciclismo", "Intermedio"),
            new DeportesDTOResponse("Futbol", "Avanzado")
    ));

    @Override
    public DeportesDTOResponse crearDeporte(DeportesDTO deporte) {
        DeportesDTOResponse deportesDto = new DeportesDTOResponse();
        deportesDto.setNombre(deporte.getNombre());
        deportesDto.setNivel(deporte.getNivel());
        deportes.add(deportesDto);
        return deportesDto;
    }

    @Override
    public List<DeportesDTOResponse> devolverDeportes() {
        return deportes;
    }

    @Override
    public DeportesDTOResponse devolverDeporte(String deporte) {
        return deportes.stream()
                .filter( deporteFiltrado -> deporteFiltrado.getNombre().equals(deporte))
                .findFirst()
                .orElse(null);
    }
}
