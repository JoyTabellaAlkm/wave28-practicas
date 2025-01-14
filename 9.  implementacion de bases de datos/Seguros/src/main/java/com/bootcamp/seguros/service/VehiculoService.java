package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.VehiculoPatenteYMarcaDTO;
import com.bootcamp.seguros.entity.Vehiculo;
import com.bootcamp.seguros.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<String> getAllPatentes() {
        return vehiculoRepository
                .findAll()
                .stream()
                .map(Vehiculo::getPatente)
                .toList();
    }

    public List<VehiculoPatenteYMarcaDTO> getAllPatentesyMarcasSortedByAnioDeFabricacion() {
        return vehiculoRepository.findAllOrderByAnioDeFabricacion()
                .stream()
                .map(vehiculo -> new VehiculoPatenteYMarcaDTO(vehiculo.getPatente(), vehiculo.getMarca()))
                .toList();
    }

    public List<String> findByPatenteFilterByFourRuedasAndCurrentAnioDeFabricacion() {
        return vehiculoRepository
                .findallFilterByFourRuedasAndAnioDeFabricacion(LocalDate.now().getYear())
                .stream()
                .map(Vehiculo::getPatente)
                .toList();
    }
}
