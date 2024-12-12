package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageVehicleDto;
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
    public AverageVehicleDto FindByBrandByPassager(String brand) {
        List<Vehicle> vehicleList=vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException(" No se encontro ningun auto " + brand);
        }
        List<Vehicle> filtered=vehicleList.stream()
                .filter(v->v.getBrand().equalsIgnoreCase(brand))
                .toList();

        if(filtered.isEmpty()){
            throw  new NotFoundException("No se encontro ningun auto con la marca ingresada");

        }

        double averyCapacity= filtered.stream()
                .mapToDouble()v->v.getPassengers():passengers)
        .av


        return null;
    }


}
