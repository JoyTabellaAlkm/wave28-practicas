package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.UpdateFuelSuccessDTO;
import com.bootcampW22.EjercicioGlobal.dto.UpdateFuelTypeDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    UpdateFuelSuccessDTO updateFuel(Long id, UpdateFuelTypeDTO updateFuelTypeDTO);
}
