package com.mercadolibre.ejercicioseguroautos.service;

import com.mercadolibre.ejercicioseguroautos.dto.ModeloMarcaPatenteDTO;
import com.mercadolibre.ejercicioseguroautos.dto.PatenteYMarcaDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculoDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculosYTotalDTO;
import lombok.Data;

import java.util.List;

public interface IVehiculoService {

    List<VehiculoDTO> getAllVehiculos();
    VehiculoDTO saveVehiculo(VehiculoDTO vehiculoDTO);
    List<String> getPatentes();
    List<PatenteYMarcaDTO> getPatentesMarcas();
    List<String> getPatenteByWheelsAndCurrentDate();
    List<ModeloMarcaPatenteDTO> getModeloMarcaPatente();
    VehiculosYTotalDTO getVehiculosYTotalPerdidas();
}
