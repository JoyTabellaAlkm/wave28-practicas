package com.example.seguros.service;

import com.example.seguros.dto.PatenteMarcaDto;
import com.example.seguros.model.Vehiculo;
import com.example.seguros.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final IVehiculoRepository vehiculoRepository;
    private final ObjectMapper mapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository, ObjectMapper mapper) {
        this.vehiculoRepository = vehiculoRepository;
        this.mapper = mapper;
    }

    //Listar las patentes de todos los vehículos registrados.
    public List<String> getAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }


    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    public List<PatenteMarcaDto> getAllPatenteAndMarcaOrderedByFabricacion() {
        return vehiculoRepository.findAllOrderedByFabricacion().stream()
                .map(v -> mapper.convertValue(v, PatenteMarcaDto.class))
                .toList();
    }

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    public List<String> filterPatenteByCantidadRuedasGreaterThanFourAndFabricacion() {
        return vehiculoRepository.filterPatenteByCantidadRuedasGreaterThanFourAndFabricacion();
    }
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos

}
