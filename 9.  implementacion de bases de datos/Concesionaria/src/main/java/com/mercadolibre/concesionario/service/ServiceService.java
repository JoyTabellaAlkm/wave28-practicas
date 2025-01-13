package com.mercadolibre.concesionario.service;

import com.mercadolibre.concesionario.dto.ServiceDTO;
import com.mercadolibre.concesionario.model.Services;

import java.util.List;

public interface ServiceService {
    public Services serviceDtoToModel(ServiceDTO serviceDTO);
    public List<Services> serviceListToDto(List<ServiceDTO> servicesDto);
    public List<ServiceDTO> serviceListToModel(List<Services> services);
    public ServiceDTO serviceModelToDto(Services services);
}
