package com.mercadolibre.concesionario.service.impl;

import com.mercadolibre.concesionario.dto.ServiceDTO;
import com.mercadolibre.concesionario.model.Services;
import com.mercadolibre.concesionario.service.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Override
    public Services serviceDtoToModel(ServiceDTO serviceDTO) {
        return null;
    }

    @Override
    public List<Services> serviceListToDto(List<ServiceDTO> servicesDto) {
        return List.of();
    }

    @Override
    public List<ServiceDTO> serviceListToModel(List<Services> services) {
        return List.of();
    }

    @Override
    public ServiceDTO serviceModelToDto(Services services) {
        return null;
    }
}
