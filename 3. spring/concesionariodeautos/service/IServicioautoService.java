package com.mercadolibre.concesionariodeautos.service;

import com.mercadolibre.concesionariodeautos.dto.ServiceDTO;
import com.mercadolibre.concesionariodeautos.model.Service;

import java.util.List;
import java.util.Optional;

public interface IServicioautoService {
    public List<ServiceDTO> readAll();
    public Optional<ServiceDTO> readById(Integer id);
    public Service create(ServiceDTO service);
}
