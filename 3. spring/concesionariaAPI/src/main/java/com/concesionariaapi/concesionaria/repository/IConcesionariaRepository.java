package com.concesionariaapi.concesionaria.repository;

import com.concesionariaapi.concesionaria.dto.ResponseDTO;
import com.concesionariaapi.concesionaria.dto.VehiculoDTO;
import com.concesionariaapi.concesionaria.model.Vehiculo;

import java.util.List;

public interface IConcesionariaRepository {
    Integer save(Vehiculo vehiculo);
    List<Vehiculo> findAll();
    Vehiculo findById(Integer id);
    List<Vehiculo> findByPrice(String since, String to);
    List<Vehiculo> findByManufacturingDate(String since, String to);

}
