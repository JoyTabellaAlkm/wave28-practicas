package com.mercadolibre.autoinsurance.service;

import com.mercadolibre.autoinsurance.dto.request.VehicleRequestDto;
import com.mercadolibre.autoinsurance.dto.response.PatentBrandAndModelResponseDto;
import com.mercadolibre.autoinsurance.dto.response.PatentBrandResponseDto;
import com.mercadolibre.autoinsurance.dto.response.VehicleAccidentResponseDto;
import com.mercadolibre.autoinsurance.dto.response.VehicleResponseDto;

import java.util.List;

public interface IVehicleService {
    VehicleResponseDto save(VehicleRequestDto vehicleRequestDto);

    List<VehicleResponseDto> findAll();

    List<String> listPatents();

    List<PatentBrandResponseDto> listPatentAndBrandOrderByYear();

    List<String> listPatentsByNumberOfWheelsAndYearOfManufacture();

    List<PatentBrandAndModelResponseDto> listPatentBrandAndModelByEconomicLoss();

    List<VehicleAccidentResponseDto> listVehiclesByEconomicLoss();
}
