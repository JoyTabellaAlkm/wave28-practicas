package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

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
    public ResponseDTO getAverageSpeedByBrand(String brand) {
        //Obtener la lista
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        //Filtrado por marca
        vehicleList = vehicleList.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).toList();
        if(vehicleList.isEmpty()) throw new NotFoundException("No se encontraron vehículos de esa marca");
        //Obtener el average
        Double averageSpeedByBrand = vehicleList.stream().mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed())).average().orElse(0.0);
        //Retornar
        return new ResponseDTO(averageSpeedByBrand);
    }
}
