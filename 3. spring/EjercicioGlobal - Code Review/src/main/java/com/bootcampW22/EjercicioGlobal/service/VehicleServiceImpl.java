package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.UpdateFuelSuccessDTO;
import com.bootcampW22.EjercicioGlobal.dto.UpdateFuelTypeDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private final ObjectMapper objectMapper;
    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository, ObjectMapper objectMapper){
        this.vehicleRepository = vehicleRepository;
        this.objectMapper = objectMapper;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UpdateFuelSuccessDTO updateFuel(Long id, UpdateFuelTypeDTO updateFuelTypeDTO) {

        if(updateFuelTypeDTO.getFuel_type().equalsIgnoreCase("gas")
                || updateFuelTypeDTO.getFuel_type().equalsIgnoreCase("gasoline")
                || updateFuelTypeDTO.getFuel_type().equalsIgnoreCase("biodiesel")
                || updateFuelTypeDTO.getFuel_type().equalsIgnoreCase("diesel")
        ) {
            Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);

            if (optionalVehicle.isEmpty()) {
                throw new NotFoundException("No se encontró el vehículo.");
            }

            Vehicle vehicle = optionalVehicle.get();
            vehicle.setFuel_type(updateFuelTypeDTO.getFuel_type());

            UpdateFuelSuccessDTO updateFuelSuccessDTO = new UpdateFuelSuccessDTO();
            updateFuelSuccessDTO.setMessage("Tipo de combustible del vehículo actualizado exitosamente.\n");
            updateFuelSuccessDTO.setVehicleDto(objectMapper.convertValue(vehicle, VehicleDto.class));
            return updateFuelSuccessDTO;

        }
        throw new BadRequestException("Tipo de combustible mal formado o no admitido");
    }
}
