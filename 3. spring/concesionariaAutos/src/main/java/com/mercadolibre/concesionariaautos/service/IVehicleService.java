package com.mercadolibre.concesionariaautos.service;

import com.mercadolibre.concesionariaautos.dto.PartialVehicleDTO;
import com.mercadolibre.concesionariaautos.dto.VehicleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {

    public String create(VehicleDTO dto);
    public List<PartialVehicleDTO> getAll();
    public List<PartialVehicleDTO> getVehiclesBetweenDates(LocalDate since, LocalDate to);
    public List<PartialVehicleDTO> getVehiclesBetweenPrices(Double since, Double to);
    public VehicleDTO getVehiclesById(Integer id);
}
