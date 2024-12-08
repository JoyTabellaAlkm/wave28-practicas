package com.example.concesionarioautos.repository;

import com.example.concesionarioautos.entity.Vehiculo;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Data
@Repository
public class VehiculoRepository {

    private HashMap<Integer, Vehiculo> listaVehiculos = new HashMap<>();
    private Integer id;

}
