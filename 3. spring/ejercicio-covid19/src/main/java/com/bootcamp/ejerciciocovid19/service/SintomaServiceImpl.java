package com.bootcamp.ejerciciocovid19.service;

import com.bootcamp.ejerciciocovid19.dto.SintomaDto;
import com.bootcamp.ejerciciocovid19.mapper.SintomaDtoMapper;
import com.bootcamp.ejerciciocovid19.model.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SintomaServiceImpl implements ISintomaService{
    List<Sintoma> sintomas = new ArrayList<>(List.of(
            new Sintoma("1A", "Dolor de cabeza", 1),
            new Sintoma("2A", "Dolor de cuerpo", 2),
            new Sintoma("3A", "Tos", 1),
            new Sintoma("4A", "Falta de aire", 10),
            new Sintoma("5A", "Dolor de pecho", 9)
    ));

    @Autowired
    SintomaDtoMapper sintomaDtoMapper;

    @Override
    public List<SintomaDto> obtenerSintomas() {
        return sintomaDtoMapper.mapLista(sintomas);
    }

    @Override
    public SintomaDto obtenerSintomaPorNombre(String nombre) {
        Optional<Sintoma> sintomaEncontrado = sintomas.stream().filter(s -> s.getNombre().equalsIgnoreCase(nombre)).findFirst();
        if (sintomaEncontrado.isPresent()) {
            return sintomaDtoMapper.mapSintoma(sintomaEncontrado.get());
        }
        return null;
    }


}
