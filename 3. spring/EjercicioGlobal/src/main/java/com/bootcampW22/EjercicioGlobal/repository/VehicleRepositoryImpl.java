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
import java.util.Optional;
import java.util.OptionalDouble;

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
    public String save(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
        return "Vehículo creado exitosamente";
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, int year) {
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == year)
                .toList();
    }

    @Override
    public List<Vehicle> findByBrandAndBetweenYear(String brand, int startYear, int endYear) {
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getBrand().equalsIgnoreCase(brand) && vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                .toList();
    }

    @Override
    public OptionalDouble averageSpeedByBrand(String brand) {
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToDouble( vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .average();
    }

    @Override
    public void multipleSaving(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
    }

    @Override
    public String updateMaxSpeed(Vehicle vehicle, String speed) {
        vehicle.setMax_speed(speed);
        return "Velocidad del vehículo actualizada exitosamente";
    }

    @Override
    public List<Vehicle> findByFuelType(String fuelType) {
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType))
                .toList();
    }

    @Override
    public String remove(Vehicle vehicle) {
        listOfVehicles.remove(vehicle);
        return "Vehículo eliminado exitosamente";
    }

    @Override
    public List<Vehicle> findByTransmissionType(String transmissionType) {
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmissionType))
                .toList();
    }

    @Override
    public String updateFuelType(Vehicle vehicle, String fuelType) {
        vehicle.setFuel_type(fuelType);
        return "Tipo de combustible del vehículo actualizado exitosamente";
    }

    @Override
    public Double averageCapacityByBrand(String brand) {
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(Vehicle::getPassengers)
                .average()
                .orElse(-1);
    }

    @Override
    public List<Vehicle> findByDimensions(double minLength, double maxLength, double minWidth, double maxWidth) {
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength && vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth)
                .toList();
    }

    @Override
    public List<Vehicle> findByWeightRange(double minWeight, double maxWeight) {
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getWeight() >= minWeight && vehicle.getWeight() <= maxWeight )
                .toList();
    }

    public Optional<Vehicle> findById(Long id){
        return listOfVehicles.stream()
                .filter( vehicle -> vehicle.getId().equals(id))
                .findFirst();
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
