package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculoRepository {
    public Long save(Vehicle vehicle);
    public List<Vehicle> findAll();
    public Vehicle findById(Long id);
    public List<Vehicle> findBetweenDates(LocalDate since, LocalDate to);
    public List<Vehicle> findBetweenPrices(Double since, Double to);
}
