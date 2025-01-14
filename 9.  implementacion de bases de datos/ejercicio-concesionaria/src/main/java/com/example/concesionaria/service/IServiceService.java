package com.example.concesionaria.service;

import com.example.concesionaria.dto.request.ServiceRequestDTO;
import com.example.concesionaria.dto.request.VehicleRequestDTO;
import com.example.concesionaria.dto.response.MessageDTO;
import com.example.concesionaria.repository.IVehicleRepository;

public interface IServiceService {

    MessageDTO createService(ServiceRequestDTO serviceRequestDTO);


}
