package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
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

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Vehicle postVehicle(Vehicle vehicleNew) {
        return null;
    }

    @Override
    public List<Vehicle> getVehiclesByDimensions(int minLength, int maxLength, int minWidth, int maxWidth) {
        return listOfVehicles.stream().filter(vehicle ->
                vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength &&
                        vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth ).toList();
    }

    @Override
    public List<Vehicle> vehiclesForBrand(String brand) {
        return listOfVehicles.stream().filter(v -> v.getBrand().equals(brand)).toList();
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
