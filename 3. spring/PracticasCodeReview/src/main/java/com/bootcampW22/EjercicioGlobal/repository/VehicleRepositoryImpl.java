package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public void addNew(VehicleDto vehicleDto) {
        listOfVehicles.add(objectMapper.convertValue(vehicleDto, Vehicle.class));
        return;
    }

    @Override
    public VehicleDto getById(Long id) {
        return objectMapper.convertValue(
            listOfVehicles.stream().filter(
                vehicle -> Objects.equals(vehicle.getId(), id)
                ).findAny().orElse(null),
                VehicleDto.class
        );
    }

    @Override
    public List<VehicleDto> getByColorAndYear(String color, Integer year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year)
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDto.class))
                .toList();
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
