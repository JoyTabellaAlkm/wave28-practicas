package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private final ObjectMapper objectMapper;
    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl(ObjectMapper objectMapper) throws IOException {
        loadDataBase();
        this.objectMapper = objectMapper;
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public List<VehicleDto> getByBrand(String brand) {
        List<VehicleDto> vehicleDtoListByBrand = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class))
                .toList();
        if(vehicleDtoListByBrand.isEmpty()){throw new NotFoundException("No se encontraron vehículos de esa marca.");}
        return vehicleDtoListByBrand;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
