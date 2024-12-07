package com.meli.concesionarioAutos.repository;

import com.meli.concesionarioAutos.entity.Vehiculo;
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
