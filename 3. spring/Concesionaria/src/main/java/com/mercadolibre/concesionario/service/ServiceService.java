package com.mercadolibre.concesionario.service;

import com.mercadolibre.concesionario.dto.ServiceDTO;
import com.mercadolibre.concesionario.model.Service;

import java.util.List;

public interface ServiceService {
    public Service serviceDtoToModel(ServiceDTO serviceDTO);
    public List<Service> serviceListToDto(List<ServiceDTO> servicesDto);
    public List<ServiceDTO> serviceListToModel(List<Service> services);
    public ServiceDTO serviceModelToDto(Service service);
}
