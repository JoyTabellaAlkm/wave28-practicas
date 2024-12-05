package com.bootcamp.deportistas.service.impl;

import com.bootcamp.deportistas.data.DeporteRepository;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.service.DeporteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteServiceImpl implements DeporteService {
    @Override
    public List<Deporte> getAllDeportes() {
        return new ArrayList<>(DeporteRepository.DATA);
    }

    @Override
    public Optional<Deporte> findBy(String nombre) {
        return DeporteRepository.DATA.stream()
                .filter(d -> d.getNombre().equals(nombre))
                .findAny();
    }
}
