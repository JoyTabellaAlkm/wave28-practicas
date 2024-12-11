package co.mercadolibre.concesionaria.service;

import co.mercadolibre.concesionaria.dto.VehicleDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IVehicleService {
    String addVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> listVehicles();
    List<VehicleDTO> listVehiclesByDate(LocalDate since, LocalDate to);
    List<VehicleDTO> listVehiclesByPrice(double since, double to);
    VehicleDTO getVehicle(String id);
}
