package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.MensajeDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;

import java.util.List;

public interface IVehicleService {
     List<VehicleDto> searchAllVehicles();

     String deleteVehicle(long id);

     //------------------------------------------

}
