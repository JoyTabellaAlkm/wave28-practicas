package com.mercadolibre.deportistas.repository.impl;

import com.mercadolibre.deportistas.model.Deporte;
import com.mercadolibre.deportistas.repository.IDeporteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository implements IDeporteRepository {

    private List<Deporte> deportes = new ArrayList<>();

    public DeporteRepository() {
        Deporte basquet = new Deporte("basquet", 2);
        Deporte futbol = new Deporte("futbol", 1);
        Deporte hockey = new Deporte("hockey", 3);
        Deporte tenis = new Deporte("tenis", 2);

        this.deportes.add(basquet);
        this.deportes.add(futbol);
        this.deportes.add(hockey);
        this.deportes.add(tenis);
    }

    @Override
    public List<Deporte> getDeportes() {
        return deportes;
    }
}
