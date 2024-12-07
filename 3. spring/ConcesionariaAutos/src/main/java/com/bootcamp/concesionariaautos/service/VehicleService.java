package com.bootcamp.concesionariaautos.service;

import com.bootcamp.concesionariaautos.dto.VehicleDTO;
import com.bootcamp.concesionariaautos.dto.VehicleDTONoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface VehicleService {
    List<VehicleDTONoServices> findAll();
    VehicleDTO findById(Long id);
    VehicleDTO save(VehicleDTO vehicleDTO);
    VehicleDTO update(VehicleDTO vehicleDTO);
    VehicleDTO deleteById(Long id);
    List<VehicleDTONoServices> findAllByManufacturingDate(
            LocalDate since,
            LocalDate to);
    List<VehicleDTONoServices> findAllByPrice(
            BigDecimal since,
            BigDecimal to);
}
