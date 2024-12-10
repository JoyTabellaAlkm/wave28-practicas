package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Long create(Vehicle vehicle) {
        Long id = vehicle.getId();
        if (listOfVehicles.stream()
                .anyMatch(v -> v.getId().equals(id))) {
            throw new ConflictException("Ya existe vehiculo con id: " + id);
        }
        listOfVehicles.add(vehicle);
        return id;
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, int year) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year)
                .toList();
    }

    @Override
    public List<Vehicle> findByBrandAndRangeYear(String brand, int startYear, int endYear) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand) && vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                .toList();
    }

    @Override
    public Double findAverageSpeedByBrand(String brand) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .map(Vehicle::getMaxSpeed)
                .mapToDouble(Double::parseDouble).average().orElse(0.0);
    }

    @Override
    public Vehicle findById(Long id) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Long updateSpeed(Vehicle vehicle, String speed) {
        int indice = listOfVehicles.indexOf(vehicle);
        vehicle.setMaxSpeed(speed);
        listOfVehicles.set(indice, vehicle);
        return vehicle.getId();
    }

    @Override
    public List<Vehicle> findByFuelType(String type) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getFuelType().equals(type)).toList();
    }

    @Override
    public void delete(Long id) {
        listOfVehicles = listOfVehicles
                .stream()
                .filter(vehicle -> !vehicle.getId().equals(id))
                .toList();
    }

    @Override
    public List<Vehicle> findByTransmissionType(String type) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getTransmission().equals(type)).toList();
    }

    @Override
    public Long updateFuel(Vehicle vehicle, String fuel) {
        int indice = listOfVehicles.indexOf(vehicle);
        vehicle.setFuelType(fuel);
        listOfVehicles.set(indice, vehicle);
        return vehicle.getId();
    }

    @Override
    public Double findAverageCapacityByBrand(String brand) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .map(Vehicle::getPassengers)
                .mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }

    @Override
    public List<Vehicle> findByDimensions(double min_length, double max_length, double min_width, double max_width) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> {
                    double length = vehicle.getHeight();
                    double width = vehicle.getWidth();
                    return (min_length <= length && length <= max_length)
                            &&
                            (min_width <= width && width <= max_width);
                })
                .toList();
    }

    @Override
    public List<Vehicle> findByWeight(double weight_min, double weight_max) {
        return listOfVehicles
                .stream()
                .filter(vehicle -> {
                    double weigth = vehicle.getWeight();
                    return weight_min <= weigth && weigth <= weight_max;
                })
                .toList();
    }


    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;

        file = ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {
        });

        listOfVehicles = vehicles;
    }
}
