package com.seguros_de_autos.service;

import com.seguros_de_autos.DTO.VehiculoDto;
import com.seguros_de_autos.DTO.VehiculoPatentesResponseDto;
import com.seguros_de_autos.DTO.VehiculoResponseDto;
import org.springframework.stereotype.Service;

public interface IVehiculoService {
    public VehiculoResponseDto createVehiculo(VehiculoDto vehiculo);
    public VehiculoPatentesResponseDto getPatentes();
}
