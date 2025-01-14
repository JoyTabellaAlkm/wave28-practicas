package com.mercadolibre.ejercicioseguroautos.service;

import com.mercadolibre.ejercicioseguroautos.dto.SiniestroDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculoDTO;
import com.mercadolibre.ejercicioseguroautos.models.Siniestro;
import com.mercadolibre.ejercicioseguroautos.models.Vehiculo;
import com.mercadolibre.ejercicioseguroautos.repository.ISiniestroRepository;
import com.mercadolibre.ejercicioseguroautos.repository.IVehiculoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroServiceImpl implements ISiniestroService {

    private final ISiniestroRepository siniestroRepository;
    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public SiniestroServiceImpl(ISiniestroRepository siniestroRepository, IVehiculoRepository vehiculoRepository){
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<SiniestroDTO> getAllSiniestros() {
        List<Siniestro> siniestros = siniestroRepository.findAll();
        List<SiniestroDTO> siniestrosDTO = siniestros.stream().map(siniestro -> modelMapper.map(siniestro, SiniestroDTO.class)).toList();

        return siniestrosDTO;
    }

    @Transactional
    @Override
    public SiniestroDTO saveSiniestro(SiniestroDTO siniestroDTO) {
        Vehiculo vehiculo = vehiculoRepository.findById(siniestroDTO.getIdVehiculo())
                .orElseThrow(() -> new RuntimeException("Vehiculo not found with id " + siniestroDTO.getIdVehiculo()));

        Siniestro siniestro = new Siniestro();
        siniestro.setFechaSiniestro(siniestroDTO.getFechaSiniestro());
        siniestro.setVehiculo(vehiculo);
        siniestro.setPerdidaEconomica(siniestroDTO.getPerdidaEconomica());

        Siniestro savedSiniestro = siniestroRepository.save(siniestro);
        return modelMapper.map(savedSiniestro, SiniestroDTO.class);
    }
}
