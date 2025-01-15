package com.mercadolibre.vehicles.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.vehicles.model.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    public List<Vehicle> findAllByManufacturingDateBetween(LocalDate since, LocalDate to);

    public List<Vehicle> findAllByPriceBetween(String since, String to);

}
