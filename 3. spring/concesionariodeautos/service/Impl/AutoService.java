package com.mercadolibre.concesionariodeautos.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.concesionariodeautos.dto.AutoDTO;
import com.mercadolibre.concesionariodeautos.dto.AutoResponseDTO;
import com.mercadolibre.concesionariodeautos.model.Auto;
import com.mercadolibre.concesionariodeautos.repository.IAutoRepository;
import com.mercadolibre.concesionariodeautos.service.IAutoService;
import com.mercadolibre.concesionariodeautos.service.IServicioautoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class AutoService implements IAutoService {

    @Autowired
    IAutoRepository autoRepository;
    @Autowired
    IServicioautoService serviceService;
    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public List<AutoResponseDTO> readAll() {
        return autoRepository.readAll().stream().map(auto -> objectMapper.convertValue(auto, AutoResponseDTO.class)).toList();
    }

    @Override
    public Optional<AutoDTO> readById(Integer id) {
        return autoRepository.readById(id).map(auto -> objectMapper.convertValue(auto, AutoDTO.class));
    }

    @Override
    public Auto create(AutoDTO auto) {
        if(!auto.getServiceList().isEmpty()){
            auto.getServiceList().forEach(service -> serviceService.create(service));
        }
        return autoRepository.create(objectMapper.convertValue(auto, Auto.class));
    }

    public List<AutoResponseDTO> readByDate(Integer since, Integer to) {
        return autoRepository.readByDate(since, to).stream().map(auto -> objectMapper.convertValue(auto, AutoResponseDTO.class)).toList();
    }
}
