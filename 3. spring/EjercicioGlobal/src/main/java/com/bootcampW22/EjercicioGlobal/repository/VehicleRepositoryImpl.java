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
    public boolean add(Vehicle vehicle) {
        return listOfVehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findVehicleByColorAndYear(String color, int year) {
       return listOfVehicles.stream()
               .filter(v -> v.getColor().equalsIgnoreCase(color) && v.getYear() == year).toList();
    }

    @Override
    public List<Vehicle> findVehicleByBrandAndYearRange(String brand, int startYear, int endYear) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand) &&
                        (v.getYear() >= startYear && v.getYear() <= endYear)).toList();
    }

    @Override
    public List<Vehicle> findVehiclesByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand)).toList();
    }

    @Override
    public boolean addAll(List<Vehicle> vehicles) {
        return listOfVehicles.addAll(vehicles);
    }

    public boolean vehicleExists(Vehicle vehicle) {
        return listOfVehicles.stream()
                .anyMatch(v -> v.getId().equals(vehicle.getId()));
    }

    @Override
    public Vehicle findById(Long id) {
        return listOfVehicles.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Vehicle> findVehicleByFuelType(String type) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type)).toList();
    }

    @Override
    public boolean delete(Vehicle vehicle) {
        return listOfVehicles.remove(vehicle);
    }

    @Override
    public List<Vehicle> getVehiclesByTransmission(String transmission) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmission)).toList();
    }

    @Override
    public List<Vehicle> getVehiclesByDimension(double min_length, double max_length, double min_width, double max_width) {
        return listOfVehicles.stream().filter(vehicle ->
                vehicle.getHeight() >= min_length &&  vehicle.getHeight() <= max_length &&
                        vehicle.getWidth() >= min_width && vehicle.getWidth() <= max_width).toList();
    }

    @Override
    public List<Vehicle> getVehiclesByWeight(double min_weight, double max_weight) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getWeight() >= min_weight &&
                vehicle.getWeight() <= max_weight).toList();
    }

    @Override
    public boolean vehicleAlreadyExists(Long id) {
       return listOfVehicles.stream().anyMatch(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public boolean addVehicleBatch(List<Vehicle> vehicles) {
        return listOfVehicles.addAll(vehicles);
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
