package com.example.concesionaria.repository;

import com.example.concesionaria.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepository {
    Map<Integer, Vehicle>  listaDeVehiculos= new HashMap<>();
    int contador = 0;

    public Vehicle encontrarVehiculo(Integer id){
        return listaDeVehiculos.get(id);
    }

    public List<Vehicle> encontrarVehiculos(){
        return listaDeVehiculos.values().stream().toList();
    }

    public Integer guardarVehiculo(Vehicle vehiculo){
        listaDeVehiculos.put(contador++, vehiculo);
        return contador;
    }
}
