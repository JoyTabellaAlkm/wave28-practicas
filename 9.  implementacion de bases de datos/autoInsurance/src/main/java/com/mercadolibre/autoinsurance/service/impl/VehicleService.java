package com.mercadolibre.autoinsurance.service.impl;

import com.mercadolibre.autoinsurance.dto.request.VehicleRequestDto;
import com.mercadolibre.autoinsurance.dto.response.*;
import com.mercadolibre.autoinsurance.entity.Vehicle;
import com.mercadolibre.autoinsurance.repository.IVehicleRepository;
import com.mercadolibre.autoinsurance.service.IVehicleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.autoinsurance.utils.Mapper.mapper;

@Service
public class VehicleService implements IVehicleService {
    private final IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleResponseDto save(VehicleRequestDto vehicleRequestDto) {
        Vehicle vehicleToSave = mapper.map(vehicleRequestDto, Vehicle.class);
        return mapper.map(vehicleRepository.save(vehicleToSave), VehicleResponseDto.class);
    }

    @Override
    public List<VehicleResponseDto> findAll() {
        return vehicleRepository.findAll().stream()
                .map(vehicle -> mapper.map(vehicle, VehicleResponseDto.class))
                .toList();
    }

    @Override
    public List<String> listPatents() {
        return vehicleRepository.findAllPatents();
    }

    @Override
    public List<PatentBrandResponseDto> listPatentAndBrandOrderByYear() {
        return vehicleRepository.findAllPatentsAndBrandOrderByYearOfManufacture();
    }

    @Override
    public List<String> listPatentsByNumberOfWheelsAndYearOfManufacture() {
        Short currentYear = (short) LocalDate.now().getYear();
        return vehicleRepository.findAllByNumberOfWheelsAndYearOfManufacture(currentYear);
    }

    @Override
    public List<PatentBrandAndModelResponseDto> listPatentBrandAndModelByEconomicLoss() {
        return vehicleRepository.findAllPatentBrandAndModelByEconomicLoss();
    }

    @Override
    public List<VehicleAccidentResponseDto> listVehiclesByEconomicLoss() {
        List<Object[]> results = vehicleRepository.findVehiclesByEconomicLoss();
        List<VehicleAccidentResponseDto> response = new ArrayList<>();

        for (Object[] result : results) {
            Vehicle vehicle = (Vehicle) result[0];
            Double totalLoss = (Double) result[1];

            VehicleAccidentResponseDto vehicleAccidentResponseDto = getVehicleAccidentResponseDto(vehicle, totalLoss);
            response.add(vehicleAccidentResponseDto);
        }
        return response;
    }

    private static VehicleAccidentResponseDto getVehicleAccidentResponseDto(Vehicle vehicle, Double totalLoss) {
        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto(
                vehicle.getId(),
                vehicle.getPatent(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getYearOfManufacture(),
                vehicle.getNumberOfWheels(),
                vehicle.getAccidents().stream()
                        .map(accident -> mapper.map(accident, AccidentResponseDto.class))
                        .toList()
        );

        return new VehicleAccidentResponseDto(vehicleResponseDto, totalLoss);
    }

}
