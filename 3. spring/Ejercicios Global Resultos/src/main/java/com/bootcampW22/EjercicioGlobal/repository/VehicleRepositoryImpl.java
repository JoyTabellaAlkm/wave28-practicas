package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.BrandSpeedAverageResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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
    public String addCar(Vehicle car) {
        listOfVehicles.add(car);
        //saveDataBase();
        return "Vehículo creado exitosamente.";
    }

    @Override
    public String addCars(List<Vehicle> cars) {
        for(Vehicle car: cars){
            listOfVehicles.add(car);
        }
        return "Vehiculos creados exitosamente";
    }

    @Override
    public List<Vehicle> findCarByColorAndYear(String color, int year) {
        return listOfVehicles.stream().filter( c -> c.getYear() == year && c.getColor().equalsIgnoreCase(color)).toList();
    }

    @Override
    public List<Vehicle> findCarsByBrandAndYear(String brand, int startYear, int endYear) {
        return listOfVehicles.stream().filter( entity -> entity.getBrand().equalsIgnoreCase(brand) && entity.getYear() >= startYear && entity.getYear() <= endYear).toList();
    }

    @Override
    public double calAverageSpeedByBrand(String brand) {
        return listOfVehicles.stream().filter(x -> x.getBrand().equalsIgnoreCase(brand)).map(x -> Integer.parseInt(x.getMax_speed())).mapToInt(Integer::intValue).average().orElseThrow(() -> new NotFoundException("No se encontro brand de vehiculos"));

    }

    @Override
    public String updateMaxSpeed(int id, String max_speed) {
        listOfVehicles = listOfVehicles.stream().map(x -> {
                if(x.getId() == id){
                    x.setMax_speed(max_speed);
                }
                return x;
        }
        ).toList();
        return "Actualizado con exito";
    }

    @Override
    public String deleteCar(Vehicle car) {
        listOfVehicles.remove(car);
        return "Vehículo eliminado exitosamente.";
    }

    @Override
    public List<Vehicle> getVehiclesByTranssmission(String type) {
        List<Vehicle> response = listOfVehicles.stream().filter(x -> x.getTransmission().equalsIgnoreCase(type)).toList();
        return response;
    }

    @Override
    public String putTypeFuel(int id, String fuel) {
        listOfVehicles = listOfVehicles.stream().map( x -> {
            if(x.getId() == id){
                x.setFuel_type(fuel);
            }
            return x;
        }).toList();
        return "Se registro con exito";
    }

    @Override
    public double averageByBrand(String brand) {
        return listOfVehicles.stream().filter(x -> x.getBrand().equalsIgnoreCase(brand)).mapToInt(Vehicle::getPassengers).average().orElseThrow( () -> new NotFoundException(" No se encontraron vehículos de esa marca."));
    }

    @Override
    public List<Vehicle> findByLarge(double minLength, double maxLength, double minWidth, double maxWidth) {
        return listOfVehicles.stream().filter(vehicle -> (
                (vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength) &&
                (vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth)
                )).toList();
    }

    @Override
    public List<Vehicle> findCarsByRangeWeight(double min, double max) {
        return listOfVehicles.stream().filter( car -> car.getWeight() >= min && car.getWeight() <= max).toList();
    }

    private void saveDataBase() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Escribe la lista actualizada de vehículos en el archivo JSON
            File file = ResourceUtils.getFile("classpath:vehicles_100.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,listOfVehicles);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de excepciones
        }
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
