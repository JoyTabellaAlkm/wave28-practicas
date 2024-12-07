package com.bootcamp.covid19.service.impl;

import com.bootcamp.covid19.dto.SintomaDTO;
import com.bootcamp.covid19.service.ISintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaServiceImpl implements ISintoma {
    List<SintomaDTO> sintomasList = new ArrayList<>();

    @Override
    public SintomaDTO agregarSintoma(SintomaDTO sintoma) {
        SintomaDTO sintomaDTO = new SintomaDTO();
        sintomaDTO.setNombre(sintoma.getNombre());
        sintomaDTO.setNivelDeGravedad(sintoma.getNivelDeGravedad());
        sintomasList.add(sintoma);
        return sintomaDTO;
    }

    @Override
    public String obtenersintonas(String sintoma) {
        SintomaDTO sintomasEncontrados = sintomasList.stream()
                .filter(m -> m.getNombre().equals(sintoma.toString()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encuentra este sintoma"));
        return ("Nivel de gravedad: " + sintomasEncontrados.getNivelDeGravedad().toString());
    }
}
