package com.bootcamp.concesionaria.repository;

import com.bootcamp.concesionaria.model.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehiculoDaoImpl implements VehiculoDao {

    private final List<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public void save(Vehiculo v) {
        vehiculos.add(v);
    }

    public Long getNextId() {
        return vehiculos.size() == 0 ? 1 : vehiculos.getLast().getId()+1;
    }

    @Override
    public List<Vehiculo> findUsados() {
        return vehiculos.stream().filter(v -> v.getKilometers() > 0).toList();
    }

    @Override
    public List<Vehiculo> findAll() {
        // para prevenir la modificacion de la lista
        return vehiculos.stream().toList();
    }

    @Override
    public Optional<Vehiculo> findById(Long id) {
        return vehiculos.stream().filter(v -> v.getId().equals(id)).findAny();
    }
}
