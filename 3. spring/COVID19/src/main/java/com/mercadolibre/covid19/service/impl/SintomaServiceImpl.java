package com.mercadolibre.covid19.service.impl;

import com.mercadolibre.covid19.dto.SintomaDTO;
import com.mercadolibre.covid19.model.Sintoma;
import com.mercadolibre.covid19.repository.CRUD;
import com.mercadolibre.covid19.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaServiceImpl implements ISintomaService {
    @Autowired
    CRUD<Sintoma> sintomaRepository;
    @Override
    public List<SintomaDTO> buscarSintomas() {
        return sintomaRepository.buscar().stream()
                .map(this::convertirModelDTO)
                .toList();
    }

    @Override
    public SintomaDTO buscarSintomaPorNombre(String nombreSintoma) {
        return convertirModelDTO(sintomaRepository.buscarPorNombre(nombreSintoma));
    }

    private SintomaDTO convertirModelDTO(Sintoma sintoma){
        return new SintomaDTO(sintoma.getCodigo()
                , sintoma.getNombre()
                , sintoma.getNivelDeGravedad());
    }
}
