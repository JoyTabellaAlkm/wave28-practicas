package com.bootcamp.ejerciciocovid19.mapper;

import com.bootcamp.ejerciciocovid19.dto.SintomaDto;
import com.bootcamp.ejerciciocovid19.model.Sintoma;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SintomaDtoMapper {
    public List<SintomaDto> mapLista(List<Sintoma> sintomas) {
        return sintomas.
                stream().
                map(s -> new SintomaDto(s.getNombre(), s.getNivelDeGravedad())).
                collect(Collectors.toList());
    }

    public SintomaDto mapSintoma(Sintoma sintoma) {
        return new SintomaDto(sintoma.getNombre(), sintoma.getNivelDeGravedad());
    }
}
