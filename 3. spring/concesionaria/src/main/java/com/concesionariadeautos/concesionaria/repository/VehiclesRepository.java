package com.concesionariadeautos.concesionaria.repository;

import com.concesionariadeautos.concesionaria.model.ServiceEntity;
import com.concesionariadeautos.concesionaria.model.Vehicles;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiclesRepository {
    private LocalDate dateCar = LocalDate.of(2012,5,20);

    private List<Vehicles> baseDeDatos = new ArrayList<>(List.of(new Vehicles(1,"Crevrolet","Corsa",dateCar,11000,5,300000.00,"ar",new ArrayList<ServiceEntity>(),3)));

    public List<Vehicles> getVehicles() {
        return baseDeDatos;
    }
}
