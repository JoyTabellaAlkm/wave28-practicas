package org.bootcampmeli.empresaseguros.Service;


import org.bootcampmeli.empresaseguros.dto.SiniestroDto;
import org.bootcampmeli.empresaseguros.model.Siniestro;
import org.bootcampmeli.empresaseguros.model.Vehiculo;
import org.bootcampmeli.empresaseguros.repository.SiniestroRepository;
import org.bootcampmeli.empresaseguros.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    SiniestroRepository siniestroRepository;


    @Override
    public Vehiculo createVehiculo(Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Siniestro createSiniestro(Siniestro siniestro){
        Vehiculo vehiculo = vehiculoRepository.findById(siniestro.getVehiculo().getId())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        siniestro.setVehiculo(vehiculo);

        return siniestroRepository.save(siniestro);
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        return vehiculoRepository.findAll();

    }

    @Override
    public List<SiniestroDto> getSiniestros(){
        List<Siniestro> siniestros = siniestroRepository.findAll();

        return siniestros.stream()
                .map(siniestro -> {
                    SiniestroDto siniestroDto = modelMapper.map(siniestro, SiniestroDto.class);

                    siniestroDto.setVehiculoId(siniestro.getVehiculo().getId());
                    return siniestroDto;
                })
                .collect(Collectors.toList());

    }

    @Override
    public List<String> getPatentes(){
       return vehiculoRepository.getPatentes();
    }
}
