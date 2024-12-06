package com.example.consecionaria.repository.impl;

import com.example.consecionaria.entity.Vehiculo;
import com.example.consecionaria.repository.IVehiculoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IVehiculoRepositoryImpl implements IVehiculoRepository {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public Vehiculo crear(Vehiculo entidad) {
       this.vehiculos.add(entidad);
       return entidad;
    }

}
