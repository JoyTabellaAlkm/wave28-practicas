package com.example.concesionario.service;

import com.example.concesionario.dto.ServiceDTO;
import com.example.concesionario.model.Service;

import java.util.List;

public interface ServiceService {
    public Service serviceDtoToModel(ServiceDTO serviceDTO);
    public List<Service> serviceListToDto(List<ServiceDTO> servicesDto);
    public List<ServiceDTO> serviceListToModel(List<Service> services);
    public ServiceDTO serviceModelToDto(Service service);
}
