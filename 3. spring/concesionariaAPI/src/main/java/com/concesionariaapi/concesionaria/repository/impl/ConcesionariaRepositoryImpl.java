package com.concesionariaapi.concesionaria.repository.impl;

import com.concesionariaapi.concesionaria.dto.VehiculoDTO;
import com.concesionariaapi.concesionaria.model.Vehiculo;
import com.concesionariaapi.concesionaria.repository.IConcesionariaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class ConcesionariaRepositoryImpl implements IConcesionariaRepository {
    private List<Vehiculo> vehiculos;

    public ConcesionariaRepositoryImpl(){
        this.vehiculos = new ArrayList<>();
    }

    @Override
    public Integer save(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        return vehiculo.getId();
    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculos;
    }

    @Override
    public Vehiculo findById(Integer id) {
        return vehiculos.stream().filter(v -> Objects.equals(v.getId(), id)).findAny().orElse(null);
    }

    @Override
    public List<Vehiculo> findByPrice(String since, String to) {
        return vehiculos.stream().filter(
                v -> v.getPrice() > Integer.parseInt(since) && v.getPrice() > Integer.parseInt(to)).collect(Collectors.toList());
        }

    @Override
    public List<Vehiculo> findByManufacturingDate(String since, String to) {
        return vehiculos.stream().filter(
                v -> v.getPrice() > Integer.parseInt(since) && v.getPrice() > Integer.parseInt(to)).collect(Collectors.toList()
        );
    }
}
