package com.bootcamp.concesionaria.repository;

import com.bootcamp.concesionaria.model.Vehiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVehiculoRepository {

    String saveVehiculo(Vehiculo vehiculo);

    List<Vehiculo> findAll();

    List<Vehiculo> findVehiculosByFechaFabricacion(LocalDate since, LocalDate to);

    List<Vehiculo> findVehiculosByPrecio(Integer since, Integer to);

    Optional<Vehiculo> findVehiculoById(Long id);

    Optional<Vehiculo> findId(Long id);
}
