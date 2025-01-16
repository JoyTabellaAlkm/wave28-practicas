package com.mercadolibre.siniestros.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.siniestros.dto.CreateSiniestroDto;
import com.mercadolibre.siniestros.dto.SiniestroDto;
import com.mercadolibre.siniestros.dto.VehiculoDto;
import com.mercadolibre.siniestros.entity.Siniestro;
import com.mercadolibre.siniestros.repository.ISiniestroRepository;
import com.mercadolibre.siniestros.repository.IVehiculoRepository;
import com.mercadolibre.siniestros.service.ISiniestroService;

@Service
public class SiniestroService implements ISiniestroService {

    @Autowired
    private ISiniestroRepository siniestroRepository;

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<SiniestroDto> findAllSiniestros() {
        return siniestroRepository.findAll()
                .stream()
                .map(s -> {
                    SiniestroDto sd = modelMapper.map(s, SiniestroDto.class);
                    sd.setVehiculo(modelMapper.map(s.getVehiculo(), VehiculoDto.class));
                    return sd;
                })
                .toList();
    }

    @Override
    public SiniestroDto saveSiniestro(CreateSiniestroDto request) {
        Siniestro toSave = modelMapper.map(request, Siniestro.class);
        toSave.setVehiculo(vehiculoRepository.findById(request.getVehiculoId()).orElseThrow());
        Siniestro saved = siniestroRepository.save(toSave);

        SiniestroDto response = modelMapper.map(saved, SiniestroDto.class);
        response.setVehiculo(modelMapper.map(saved.getVehiculo(), VehiculoDto.class));
        return response;
    }

}
