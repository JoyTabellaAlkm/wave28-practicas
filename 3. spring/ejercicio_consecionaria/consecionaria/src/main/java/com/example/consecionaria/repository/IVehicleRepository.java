package com.example.consecionaria.repository;

import com.example.consecionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {
    void create(Vehicle entity);
    List<Vehicle> getAll();
    List<Vehicle> getByManufacturingDate(LocalDate since, LocalDate to);
    List<Vehicle> getByPrices(double since, double to);
    Vehicle getById(int id);
}
