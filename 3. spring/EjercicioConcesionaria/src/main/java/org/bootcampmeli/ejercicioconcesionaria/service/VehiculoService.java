package org.bootcampmeli.ejercicioconcesionaria.service;

import org.bootcampmeli.ejercicioconcesionaria.dto.VehiculoDTO;
import org.bootcampmeli.ejercicioconcesionaria.entity.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VehiculoService {


    public long insertVehiculo(VehiculoDTO vehiculo);

    public List<VehiculoDTO> getVehiculos();

    public List<VehiculoDTO> getVehiculoByFabricacion();




}
