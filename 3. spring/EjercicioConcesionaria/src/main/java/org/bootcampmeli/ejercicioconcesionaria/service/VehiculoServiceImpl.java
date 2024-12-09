package org.bootcampmeli.ejercicioconcesionaria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bootcampmeli.ejercicioconcesionaria.dto.VehiculoDTO;
import org.bootcampmeli.ejercicioconcesionaria.entity.Vehiculo;
import org.bootcampmeli.ejercicioconcesionaria.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VehiculoServiceImpl implements VehiculoService {

@Autowired
    VehiculoRepository vehiculoRepository;

    @Override
    public long insertVehiculo(VehiculoDTO vehiculoDTO) {

        ObjectMapper mapper = new ObjectMapper();
        Vehiculo vehiculo = mapper.convertValue(vehiculoDTO, Vehiculo.class);
        return vehiculoRepository.save(vehiculo);

    }

    @Override
    public List<VehiculoDTO> getVehiculos() {
        return List.of();
    }

    @Override
    public List<VehiculoDTO> getVehiculoByFabricacion() {
        return List.of();
    }
}
