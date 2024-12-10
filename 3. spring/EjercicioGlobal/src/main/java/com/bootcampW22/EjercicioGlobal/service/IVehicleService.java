package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.UpdateVehicleBySpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String getAllVehiclesByBrand(String brand);
    List<VehicleDto> getAllVehiclesByFullSpeed(String type);
    ResponseDTO deleteVehicleById(int id);
    ResponseDTO createVehicle(VehicleDto vehiclesDtos);
    ResponseDTO updateVehicleBySpeed(long id, UpdateVehicleBySpeedDTO updateVehicleBySpeedDTO);
    ResponseDTO createMultipleVehicles(List<VehicleDto> vehiclesDtos);
    List<VehicleDto> findAllVehicleWithSpecificDimensions(String length, String width);
}
