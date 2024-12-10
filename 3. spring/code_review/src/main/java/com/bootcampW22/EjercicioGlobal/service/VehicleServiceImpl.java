package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.FuelDto;
import com.bootcampW22.EjercicioGlobal.dto.SpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long saveVehicle(VehicleDto vehicleDto) {
        areAllAttributesNotNull(vehicleDto);
        Long id = vehicleRepository.create(mapper.convertValue(vehicleDto, Vehicle.class));
        return id;
    }

    @Override
    public List<VehicleDto> searchByColorAndYear(String color, int year) {
        List<Vehicle> vehicleList = vehicleRepository.findByColorAndYear(color, year);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema que cumpla con " +
                    "color: " + color + " y año: " + year + ".");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchByBrandAndRangeYear(String brand, int startYear, int endYear) {
        List<Vehicle> vehicleList = vehicleRepository.findByBrandAndRangeYear(brand, startYear,
                endYear);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema que cumpla con " +
                    "brand: " + brand + " y este entre el " + startYear + " y el " + endYear);
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Double searchAverageSpeedByBrand(String brand) {
        Double average = vehicleRepository.findAverageSpeedByBrand(brand);
        if (average.equals(0.0)) {
            throw new NotFoundException("No se encontró ningun auto en el sistema que cumpla con " +
                    "brand: " + brand);
        }
        return average;
    }

    @Override
    public String saveManyVehicle(List<VehicleDto> vehicleDtos) {
        vehicleDtos.forEach(this::saveVehicle);
        return "All created";
    }

    @Override
    public Long updateSpeed(SpeedDto speedDto, Long id) {
        areAllAttributesNotNull(speedDto);
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            throw new NotFoundException("No se encontró ningun auto en el sistema con id: " + id);
        }
        Long idUpdated = vehicleRepository.updateSpeed(vehicle, speedDto.getMaxSpeed());
        return idUpdated;
    }

    @Override
    public List<VehicleDto> searchByFuelType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.findByFuelType(type);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema con " +
                    "fuel_type: " + type);
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            throw new NotFoundException("No se encontró ningun auto en el sistema con id: " + id);
        }
        vehicleRepository.delete(id);
    }

    @Override
    public List<VehicleDto> searchByTransmissionType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.findByTransmissionType(type);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema con " +
                    "transmission: " + type);
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long updateFuel(FuelDto fuelDto, Long id) {
        areAllAttributesNotNull(fuelDto);
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            throw new NotFoundException("No se encontró ningun auto en el sistema con id: " + id);
        }
        Long idUpdated = vehicleRepository.updateFuel(vehicle, fuelDto.getFuelType());
        return idUpdated;
    }

    @Override
    public Double searchAverageCapacityByBrand(String brand) {
        Double average = vehicleRepository.findAverageCapacityByBrand(brand);
        if (average.equals(0.0)) {
            throw new NotFoundException("No se encontró ningun auto en el sistema que cumpla con " +
                    "brand: " + brand);
        }
        return average;
    }

    @Override
    public List<VehicleDto> searchByDemensions(double min_length, double max_length, double min_width, double max_width) {
        List<Vehicle> vehicleList = vehicleRepository.findByDimensions(
                min_length,
                max_length,
                min_width,
                max_width
        );
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema con " +
                    "los rangos de length y width establecidos");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchByWeight(double weight_min, double weight_max) {
        List<Vehicle> vehicleList = vehicleRepository.findByWeight(weight_min, weight_max);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema con " +
                    "los rangos de weight establecidos");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    private void areAllAttributesNotNull(Object obj) {
        if (obj == null) {
            throw new BadRequestException("El " + obj.getClass().getName() + " no puede ser nulo");
        }

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (value == null) {
                    throw new BadRequestException("El campo " + field.getName() + " no puede ser nulo");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
