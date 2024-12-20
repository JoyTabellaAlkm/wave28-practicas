package com.bootcampW22.EjercicioGlobal.repository;

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
import java.util.Optional;

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

    public List<Vehicle> findByColorAndYear(String color, int year){
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == year).toList();
    }

    public List<Vehicle> findByBrandAndAgeRange(String brand, Integer start_year, Integer end_year){
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .filter(vehicle -> vehicle.getYear() >= start_year && vehicle.getYear() <= end_year)
                .toList();
    }

    public Double findByAverageSpeedByBrand(String brand){
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .average()
                .orElse(0.0);
    }

    public List<Vehicle> findByFuelType(String type){
        return listOfVehicles.stream().filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type)).toList();
    }

    public List<Vehicle> findByTransmissionType(String transmission){
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmission))
                .toList();
    }

    @Override
    public List<Vehicle> findByDimensions(double min_length, double max_length, double min_width, double max_width) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWidth() >= min_width && vehicle.getWidth() <= max_width && vehicle.getHeight() >= min_length && vehicle.getHeight() <= max_length)
                .toList();
    }

    @Override
    public List<Vehicle> findByWeightRange(double weight_min, double weight_max) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWeight() >= weight_min && vehicle.getWeight() <= weight_max)
                .toList();
    }

    @Override
    public Double averageCapacityByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElse(0.0);
    }

    @Override
    public String remove(Vehicle vehicle) {
        listOfVehicles.remove(vehicle);
        return "Vehiculo eliminado exitosamente";
    }

    @Override
    public String save(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
        return "Vehiculo creado exitosamente";
    }

    @Override
    public String saveMany(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
        return "Vehiculos creados exitosamente";
    }

    @Override
    public String updateMaxSpeed(Vehicle vehicle, String max_speed) {
        vehicle.setMax_speed(max_speed);
        return "Maxima velocidad actualizada con exito";
    }

    @Override
    public String updateFuelType(Vehicle vehicle, String fuel_type) {
        vehicle.setFuel_type(fuel_type);
        return "Tipo de combustible actualizado con exito";
    }

    public Optional<Vehicle> findById(Long id){
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
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
