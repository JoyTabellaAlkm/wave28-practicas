package com.ejercicio.autos.Repository.impl;

import com.ejercicio.autos.Model.Vehiculo;
import com.ejercicio.autos.Repository.iVehiculoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class VehiculoRepositoryImpl implements iVehiculoRepository {

    private List<Vehiculo> vehiculos;

    public VehiculoRepositoryImpl() {
        this.vehiculos = new ArrayList<>();
    }

    @Override
    public Boolean agregarVehiculo(Vehiculo vehiculo) {
        try {
            vehiculos.add(vehiculo);
            return true;
        }
        catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public List<Vehiculo> retornarUsados() {
        return vehiculos;
    }

    @Override
    public List<Vehiculo> retornarVehiculosFechas(LocalDate since, LocalDate to) {
        return vehiculos.stream().filter(x -> (x.getManufacturingDate().isAfter(since)) && (x.getManufacturingDate().isBefore(to))).toList();
    }

    @Override
    public List<Vehiculo> retornarVehiculosPrecios(double since, double to) {
        return vehiculos.stream().filter(x -> (x.getPrice() >= since) && (x.getPrice() <= to)).toList();
    }

    @Override
    public Vehiculo buscarVehiculoID(int id) {
        try {
            return vehiculos.stream().filter(x -> x.getId() == id).findFirst().get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}
