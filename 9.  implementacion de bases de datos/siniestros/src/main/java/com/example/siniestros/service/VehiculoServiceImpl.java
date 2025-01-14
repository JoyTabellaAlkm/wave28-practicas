package com.example.siniestros.service;

import com.example.siniestros.dto.PatenteMarcaDto;
import com.example.siniestros.dto.PatenteMarcaModeloDto;
import com.example.siniestros.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
    ModelMapper mapper = new ModelMapper();
    @Autowired
    VehiculoRepository vehiculoRepository;
    @Override
    public List<String> getPatentes() {
        return vehiculoRepository.findPatentes();
    }

    @Override
    public List<PatenteMarcaDto> getPatenteMarca() {
        return vehiculoRepository.findPatenteMarcaOrderByAñoFabricacion().stream()
                .map(v-> new PatenteMarcaDto(v))
                .toList();
        //A arreglar
    }

    @Override
    public List<String> getPatenteByCantRuedasAndAñoFabricacion() {
        return vehiculoRepository.findPatenteByCantRuedasAndAñoFabricacion();
    }

    @Override
    public List<PatenteMarcaModeloDto> findByPerdidaValorGreaterThan10000() {
        return vehiculoRepository.findByPerdidaValorGreaterThan10000().stream()
                .map(v-> new PatenteMarcaModeloDto(v))
                .toList();
    }


}
