package com.ejercicio.autos.Service.impl;

import com.ejercicio.autos.DTO.UsadosDTO;
import com.ejercicio.autos.DTO.VehiculoDTO;
import com.ejercicio.autos.Model.Vehiculo;
import com.ejercicio.autos.Repository.iVehiculoRepository;
import com.ejercicio.autos.Service.iVehiculoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.RemoteObject;
import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoServiceImpl implements iVehiculoService {

    @Autowired
    private iVehiculoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Boolean agregarVehiculo(VehiculoDTO vehiculo) {
        try {
            Vehiculo v = objectMapper.convertValue(vehiculo, Vehiculo.class);
            repository.agregarVehiculo(v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UsadosDTO> retornarUsados() {
        List<Vehiculo> vehiculos =  repository.retornarUsados();
        return objectMapper.convertValue(vehiculos, new TypeReference<List<UsadosDTO>>() {});
    }

    @Override
    public List<VehiculoDTO> retornarUsadosFecha(LocalDate since, LocalDate to) {
        List<VehiculoDTO> listaVehiculos = objectMapper.convertValue(repository.retornarVehiculosFechas(since, to), new TypeReference<List<VehiculoDTO>>() {});
        return listaVehiculos;
    }

    @Override
    public List<VehiculoDTO> retornarUsadosPrecio(double since, double to) {
        List<VehiculoDTO> listaVehiculos = objectMapper.convertValue(repository.retornarVehiculosPrecios(since, to), new TypeReference<List<VehiculoDTO>>() {});
        return listaVehiculos;
    }

    @Override
    public VehiculoDTO buscarVehiculoID(int id) {
        return objectMapper.convertValue(repository.buscarVehiculoID(id), VehiculoDTO.class);
    }
}
