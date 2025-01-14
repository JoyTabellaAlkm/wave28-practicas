package com.seguros_de_autos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguros_de_autos.DTO.SiniestroDto;
import com.seguros_de_autos.DTO.SiniestroResponseDto;
import com.seguros_de_autos.entity.Siniestro;
import com.seguros_de_autos.entity.Vehiculo;
import com.seguros_de_autos.reposiroty.ISiniestroRepository;
import com.seguros_de_autos.reposiroty.IVehiculoRepository;
import com.seguros_de_autos.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiniestroServiceImp implements ISiniestroService {

    @Autowired
    private ISiniestroRepository siniestroRepository;

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public SiniestroResponseDto createSiniestro(SiniestroDto siniestro) {
        Vehiculo vehiculo = vehiculoRepository.findByPatente(siniestro.getPatente());
        if (vehiculo == null){
            throw new RuntimeException("Vehiculo no existe");
        }
        Siniestro newSiniestro = new Siniestro(
                null,
                siniestro.getFechaDelSiniestro(),
                siniestro.getPerdidadEconomica(),
                vehiculo
        );
        System.out.println(newSiniestro);
        Siniestro savedSiniestro = siniestroRepository.save(newSiniestro);
        return new SiniestroResponseDto(
                savedSiniestro.getId(),
                savedSiniestro.getFechaDelSiniestro(),
                savedSiniestro.getPerdidadEconomica(),
                savedSiniestro.getVehiculo().getPatente()
        );
    }
}
