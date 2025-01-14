package com.mercadolibre.ejercicioseguroautos.service;

import com.mercadolibre.ejercicioseguroautos.dto.ModeloMarcaPatenteDTO;
import com.mercadolibre.ejercicioseguroautos.dto.PatenteYMarcaDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculoDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculosYTotalDTO;
import com.mercadolibre.ejercicioseguroautos.models.Siniestro;
import com.mercadolibre.ejercicioseguroautos.models.Vehiculo;
import com.mercadolibre.ejercicioseguroautos.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<VehiculoDTO> getAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        // que convierta a dto o array vacio
        List<VehiculoDTO> vehiculosDTO = vehiculos.stream().map(vehiculo -> modelMapper.map(vehiculo, VehiculoDTO.class)).toList();

        return vehiculosDTO;
    }

    @Override
    public VehiculoDTO saveVehiculo(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = modelMapper.map(vehiculoDTO, Vehiculo.class);
        Vehiculo savedVehiculo = vehiculoRepository.save(vehiculo);
        VehiculoDTO savedVehiculoDTO = modelMapper.map(savedVehiculo, VehiculoDTO.class);
        return savedVehiculoDTO;
    }

    @Override
    public List<String> getPatentes() {
        return vehiculoRepository.getPatentes();
    }

    @Override
    public List<PatenteYMarcaDTO> getPatentesMarcas() {
        return vehiculoRepository.getVehiculosOrdenadosPorFabricacion()
                .stream()
                .map(vehiculo -> modelMapper.map(vehiculo, PatenteYMarcaDTO.class)).toList();
    }

    @Override
    public List<String> getPatenteByWheelsAndCurrentDate() {
        return vehiculoRepository.getPatentesConRuedas();
    }

    @Override
    public List<ModeloMarcaPatenteDTO> getModeloMarcaPatente() {
        return vehiculoRepository.getVehiculosConSiniestroMayorA10000()
                .stream()
                .map(vehiculo -> modelMapper.map(vehiculo, ModeloMarcaPatenteDTO.class)).toList();
    }

    @Override
    public VehiculosYTotalDTO getVehiculosYTotalPerdidas() {
        List<Vehiculo> vehiculos = vehiculoRepository.getVehiculosConSiniestroMayorA10000();

        double total = vehiculos.stream()
                .flatMap(v -> v.getSiniestros().stream())
                .mapToDouble(Siniestro::getPerdidaEconomica)
                .sum();



        VehiculosYTotalDTO dto = new VehiculosYTotalDTO(vehiculos.stream().map(vehiculo -> modelMapper.map(vehiculo, VehiculoDTO.class)).toList(), total);

        return dto;

    }
}
