package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestData;
import com.bootcampW22.EjercicioGlobal.exception.DuplicateException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
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
    public void addNewVehicle(VehicleDto vehicleDto) {
        if(isNull(getById(vehicleDto.getId()))){throw new DuplicateException("This element alredy exists");};
        if(!validateVehicleDTO(vehicleDto)){ throw new BadRequestData("Invalid data");}
        vehicleRepository.addNew(vehicleDto);
    }

    @Override
    public List<VehicleDto> getByColorAndYear(String color, Integer year) {
        List<VehicleDto> vehicles = vehicleRepository.getByColorAndYear(color, year);
        if(vehicles.isEmpty()){throw new NotFoundException("Not found");}
        return vehicles;
    }

    public VehicleDto getById(Long id){
        return vehicleRepository.getById(id);
    }

    public <T> boolean isNull(T element){
        return element != null;
    }

    public boolean validateVehicleDTO(VehicleDto vehicleDto){
        return isNull(vehicleDto.getId()) &&
                isNull(vehicleDto.getBrand()) &&
                isNull(vehicleDto.getColor()) &&
                isNull(vehicleDto.getHeight()) &&
                isNull(vehicleDto.getModel()) &&
                isNull(vehicleDto.getPassengers()) &&
                isNull(vehicleDto.getFuel_type()) &&
                isNull(vehicleDto.getYear()) &&
                isNull(vehicleDto.getWeight()) &&
                isNull(vehicleDto.getMax_speed()) &&
                isNull(vehicleDto.getRegistration()) &&
                isNull(vehicleDto.getTransmission()) &&
                isNull(vehicleDto.getWidth());
    }
}
