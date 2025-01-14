package com.melibootcamp.empresadeseguros.service;


import com.melibootcamp.empresadeseguros.dto.SiniestroDTO;
import com.melibootcamp.empresadeseguros.dto.VehiculoInfoDTO;
import com.melibootcamp.empresadeseguros.entity.Siniestro;
import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import com.melibootcamp.empresadeseguros.repository.SiniestroRepository;
import com.melibootcamp.empresadeseguros.repository.VehiculoRepository;
import com.melibootcamp.empresadeseguros.service.interfaces.ISiniestroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroServiceImpl implements ISiniestroService {

    private final SiniestroRepository siniestroRepository;
    private final VehiculoRepository vehiculoRepository;

    public SiniestroServiceImpl(SiniestroRepository siniestroRepository, VehiculoRepository vehiculoRepository){
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<SiniestroDTO> getSiniestros() {
        return siniestroRepository.findAll().stream()
                .map(s -> new SiniestroDTO(
                        s.getId(),
                        s.getFechaSiniestro().toString(),
                        s.getPerdidaEconomica(),
                        s.getVehiculoAsignado().getId(),
                        s.getVehiculoAsignado().getPatente()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public boolean saveSiniestro(Siniestro siniestro) {
          Vehiculo vehiculo = vehiculoRepository.findById(siniestro.getVehiculoAsignado().getId()).orElse(null);
            if (vehiculo != null) {
                siniestro.setVehiculoAsignado(vehiculo);
                siniestroRepository.save(siniestro);
                return true;
            } return false;

    }


    @Override
    public Siniestro getSiniestroById(long id) {
        Siniestro toReturn = siniestroRepository.findById(id).orElse(null);
        return toReturn;
    }



}
