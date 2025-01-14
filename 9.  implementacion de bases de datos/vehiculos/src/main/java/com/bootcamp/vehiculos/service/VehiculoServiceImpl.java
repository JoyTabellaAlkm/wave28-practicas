package com.bootcamp.vehiculos.service;

import com.bootcamp.vehiculos.dto.PatenteMarcaModeloDto;
import com.bootcamp.vehiculos.dto.PerdidaVehiculoDto;
import com.bootcamp.vehiculos.entity.Vehiculo;
import com.bootcamp.vehiculos.exception.NotFoundException;
import com.bootcamp.vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo crearVehiculo(Vehiculo v) {
        return vehiculoRepository.save(v);
    }

    @Override
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo getById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public List<PerdidaVehiculoDto> sumarPerdidas() {
        List<List<Object>> res =
                vehiculoRepository.sumPerdidaBySiniestroWithPerdidaGreaterThan10000();
        return res.stream()
                .map(fila -> new PerdidaVehiculoDto((String) fila.get(0), (String) fila.get(1), (String) fila.get(2), (Double) fila.get(3)))
                .toList();
    }

    @Override
    public List<PatenteMarcaModeloDto> findMatriculaYMarcaYModeloBySiniestroWithPerdidaGreaterThan10000() {
        List<List<String>> res =
                vehiculoRepository.findMatriculaYMarcaYModeloBySiniestroWithPerdidaGreaterThan10000();
        return res.stream()
                .map(fila -> new PatenteMarcaModeloDto(fila.get(0), fila.get(1), fila.get(2)))
                .toList();
    }
}
