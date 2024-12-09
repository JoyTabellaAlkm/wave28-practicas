package com.mercadolibre.concesionariodeautos.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.concesionariodeautos.dto.ServiceDTO;
import com.mercadolibre.concesionariodeautos.model.Service;
import com.mercadolibre.concesionariodeautos.repository.IServiceRepository;
import com.mercadolibre.concesionariodeautos.service.IServicioautoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServicioautoService implements IServicioautoService {

    @Autowired
    IServiceRepository serviceRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private ServicioautoService() {
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public List<ServiceDTO> readAll() {
        return serviceRepository.readAll().stream().map(service -> objectMapper.convertValue(service, ServiceDTO.class)).toList();
    }

    @Override
    public Optional<ServiceDTO> readById(Integer id) {
        return serviceRepository.readById(id).map(service -> objectMapper.convertValue(service, ServiceDTO.class));
    }

    @Override
    public Service create(ServiceDTO service) {
        return serviceRepository.create(objectMapper.convertValue(service, Service.class));
    }
}
