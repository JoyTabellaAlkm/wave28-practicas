package com.bootcamp.concesionaria.repository;

import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.model.Vehiculo;

import java.util.List;
import java.util.Optional;


public interface VehiculoDao {
    void save(Vehiculo v);
    Long getNextId();
    List<Vehiculo> findUsados();
    List<Vehiculo> findAll();
    Optional<Vehiculo> findById(Long id);
}
