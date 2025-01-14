package com.bootcamp.ejercicio_seguros.service.impl;

import com.bootcamp.ejercicio_seguros.dto.*;
import com.bootcamp.ejercicio_seguros.model.Siniestro;
import com.bootcamp.ejercicio_seguros.model.Vehiculo;
import com.bootcamp.ejercicio_seguros.repository.VehiculoRepository;
import com.bootcamp.ejercicio_seguros.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<VehiculoDTO> listarTodos() {
        return vehiculoRepository.findAll().stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoDTO.class))
                .toList();
    }

    public List<String> listarPatentes() {
        return vehiculoRepository.findAll().stream()
                .map(Vehiculo::getPatente)
                .toList();
    }

    public List<VehiculoPatenteMarcaDTO> listarPatentesMarcasOrdenadasPorAnio() {
        return vehiculoRepository.findAllOrderByAnio().stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoPatenteMarcaDTO.class))
                .toList();
    }

    public List<String> listarVehiculosPorRuedasYAnio(int cantidadRuedas, int anio) {
        return vehiculoRepository.findByCantidadRuedasGreaterThanAndAnio(cantidadRuedas, anio).stream()
                .map(Vehiculo::getPatente)
                .toList();
    }

    @Override
    public List<VehiculoPatenteMarcaModeloDTO> listarVehiculosConPerdidaMayor(double cantidad) {
        return vehiculoRepository.findVehiculoByPerdidaEconomicaGreaterThan(cantidad).stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoPatenteMarcaModeloDTO.class))
                .toList();
    }

    public ListaVehiculoSiniestroDTO listarVehiculosConPerdidaMayorTotalPerdida(double cantidad) {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        List<VehiculoSiniestroDTO> vehiculoSiniestroDTOS = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getSiniestros().stream()
                        .anyMatch(siniestro -> siniestro.getPerdidaEconomica() >= cantidad))
                .map(vehiculo -> new VehiculoSiniestroDTO(
                        modelMapper.map(vehiculo, VehiculoPatenteMarcaModeloDTO.class),
                        Double.valueOf(String.format("%.2f",
                                vehiculo.getSiniestros().stream()
                                        .filter(siniestro -> siniestro.getPerdidaEconomica() >= cantidad)
                                        .map(Siniestro::getPerdidaEconomica)
                                        .reduce(0.0, Double::sum)
                        ).replace(',', '.'))
                ))
                .toList();
        return new ListaVehiculoSiniestroDTO(vehiculoSiniestroDTOS,
                Double.valueOf(String.format("%.2f",
                        vehiculoSiniestroDTOS.stream().map(VehiculoSiniestroDTO::getPerdidaTotal)
                                .reduce(0.0, Double::sum)).replace(',', '.')));
    }
}
