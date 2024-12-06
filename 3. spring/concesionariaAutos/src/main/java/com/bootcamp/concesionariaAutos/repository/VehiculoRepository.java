package com.bootcamp.concesionariaAutos.repository;

import com.bootcamp.concesionariaAutos.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiculoRepository {
    List<Vehiculo> vehiculos = new ArrayList<>();

    public boolean saveVehiculo(Vehiculo vehiculo) {
        return vehiculos.add(vehiculo);
    }
}
