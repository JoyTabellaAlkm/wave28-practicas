package com.bootcamp.concesionaria.repository.impl;

import com.bootcamp.concesionaria.model.Vehiculo;
import com.bootcamp.concesionaria.repository.IVehiculoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

    List<Vehiculo> vehiculoList = new ArrayList<>();
    @Override
    public String saveVehiculo(Vehiculo vehiculo) {
        vehiculoList.add(vehiculo);
        return vehiculo.toString();
    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoList;
    }

    @Override
    public List<Vehiculo> findVehiculosByFechaFabricacion(LocalDate since, LocalDate to) {
        return null;
                /*vehiculoList.stream()
                .filter(v-> v.getManufacturingDate()>= since && v.getManufacturingDate()<= to)
                .toList();*/
    }

    @Override
    public List<Vehiculo> findVehiculosByPrecio(Integer since, Integer to) {
        return vehiculoList.stream().filter(v-> v.getPrice()>= since && v.getPrice()<=to)
                .toList();
    }

    @Override
    public Optional<Vehiculo> findVehiculoById(Long id) {
        return vehiculoList.stream()
                .filter(v-> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Vehiculo> findId(Long id) {
        return null;
                /*vehiculoList.stream()
                .filter(v->v.getId().equals(id))
                .findFirst();*/
    }
}
