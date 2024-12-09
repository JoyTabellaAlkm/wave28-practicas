package com.mercadolibre.cardealership.service;

import com.mercadolibre.cardealership.dto.VehicleDto;
import com.mercadolibre.cardealership.dto.response.VehicleResDto;
import com.mercadolibre.cardealership.model.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    String save(VehicleDto vehicle);
    List<VehicleResDto> findAll();
    List<VehicleDto> findByManufacturingDate(LocalDate since, LocalDate to);
    List<VehicleDto> findByPrice(Double since, Double to);
    VehicleDto findById(Integer id);
}
