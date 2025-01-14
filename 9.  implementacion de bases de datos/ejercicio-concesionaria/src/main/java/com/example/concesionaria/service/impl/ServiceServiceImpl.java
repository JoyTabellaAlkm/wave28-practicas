package com.example.concesionaria.service.impl;

import com.example.concesionaria.dto.request.ServiceRequestDTO;
import com.example.concesionaria.dto.response.MessageDTO;
import com.example.concesionaria.model.VService;
import com.example.concesionaria.repository.IServiceRepository;
import com.example.concesionaria.service.IServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements IServiceService {

    IServiceRepository serviceRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ServiceServiceImpl(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public MessageDTO createService(ServiceRequestDTO serviceRequestDTO) {
        serviceRepository.save(modelMapper.map(serviceRequestDTO, VService.class));
        return new MessageDTO("Vehículo creado correctamente.");
    }
}

