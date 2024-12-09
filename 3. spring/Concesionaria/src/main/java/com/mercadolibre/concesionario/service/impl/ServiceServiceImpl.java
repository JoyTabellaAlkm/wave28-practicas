package com.mercadolibre.concesionario.service.impl;

import com.mercadolibre.concesionario.dto.ServiceDTO;
import com.mercadolibre.concesionario.model.Service;
import com.mercadolibre.concesionario.service.ServiceService;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    public Service serviceDtoToModel(ServiceDTO serviceDTO){
        return new Service(serviceDTO.getDate(), serviceDTO.getKilometers(), serviceDTO.getDescriptions());
    }
    public List<Service> serviceListToDto(List<ServiceDTO> servicesDto){
        return servicesDto.stream().map(this::serviceDtoToModel).toList();
    }
    public ServiceDTO serviceModelToDto(Service service){
        return new ServiceDTO(service.getDate(), service.getKilometers(), service.getDescriptions());
    }
    public List<ServiceDTO> serviceListToModel(List<Service> services){
        return services.stream().map(this::serviceModelToDto).toList();
    }
}
