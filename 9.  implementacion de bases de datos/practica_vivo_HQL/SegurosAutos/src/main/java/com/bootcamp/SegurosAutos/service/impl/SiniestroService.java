package com.bootcamp.SegurosAutos.service.impl;

import com.bootcamp.SegurosAutos.dto.SiniestroDto;
import com.bootcamp.SegurosAutos.entity.Siniestro;
import com.bootcamp.SegurosAutos.entity.Vehiculo;
import com.bootcamp.SegurosAutos.exception.NotFoundException;
import com.bootcamp.SegurosAutos.repository.ISiniestroRepository;
import com.bootcamp.SegurosAutos.repository.IVehiculoRepository;
import com.bootcamp.SegurosAutos.service.ISiniestroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroService implements ISiniestroService {

    private final ISiniestroRepository siniestroRepository;
    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public SiniestroService(ISiniestroRepository siniestroRepository,
                            IVehiculoRepository vehiculoRepository) {
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public void post(Long vehiculoId, SiniestroDto dto) {
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new NotFoundException(""));

        Siniestro siniestro = new Siniestro();
        modelMapper.map(dto, siniestro);
        siniestro.setVehiculo(vehiculo);
    }

    @Override
    public List<SiniestroDto> getAll() {
        return siniestroRepository.findAll().stream()
                .map(siniestro -> modelMapper.map(siniestro, SiniestroDto.class))
                .toList();
    }
}
