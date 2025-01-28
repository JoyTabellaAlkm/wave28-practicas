package com.bootcampW22.EjercicioGlobal.unitTest.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRepositoryTest {

    @Test
    @DisplayName("Cuando se llama findAll debe retornar todos los vehículos")
    void whereFindAllShouldReturnAllVehicles() throws IOException {
        // arrange
        IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        // act
        List<Vehicle> vehicles = vehicleRepository.findAll();

        // assert
        assertFalse(vehicles.isEmpty());
        assertEquals(5, vehicles.size());
    }

    @Test
    @DisplayName("1. Buscar vehiculos por color y año")
    void whenFindVehiclesByYearAndColorShouldReturnVehicles() throws IOException {
        // arrange
        IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        Vehicle vehicle = new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180km/h", 5, "Gasoline", "Manual", 1.4, 1.8, 1500);
        vehicleRepository.findAll().add(vehicle);  // Agregar un vehículo para el test

        // act
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByYearAndColor("Red", 2020);

        // assert
        assertNotNull(vehicles);
        assertEquals(1, vehicles.size());
        assertEquals("Toyota", vehicles.get(0).getBrand());
        assertEquals(2020, vehicles.get(0).getYear());
    }

    @Test
    @DisplayName("2. Buscar vehículos por marca y rango de años")
    void whenFindVehiclesByBrandAndRangeOfYearShouldReturnVehicles()  throws IOException {
        // arrange
        IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        Vehicle vehicle = new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180km/h", 5, "Gasoline", "Manual", 1.4, 1.8, 1500);
        vehicleRepository.findAll().add(vehicle);  // Agregar un vehículo para el test

        // act
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByBrandAndRangeOfYear("Toyota", 2018, 2022);

        // assert
        assertNotNull(vehicles);
        assertEquals(1, vehicles.size());
        assertEquals("Toyota", vehicles.get(0).getBrand());
        assertEquals(2020, vehicles.get(0).getYear());
    }

    @Test
    @DisplayName("3. Consultar velocidad promedio por marca")
    void whenFindVehiclesByBrandShouldReturnVehicles()  throws IOException {
        // arrange
        IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        Vehicle vehicle = new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180km/h", 5, "Gasoline", "Manual", 1.4, 1.8, 1500);
        vehicleRepository.findAll().add(vehicle);  // Agregar un vehículo para el test

        // act
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByBrand("Toyota");

        // assert
        assertNotNull(vehicles);
        assertEquals(2, vehicles.size());
        assertEquals("Toyota", vehicles.get(0).getBrand());
    }

    @Test
    @DisplayName("5. Listar vehículos por rango de peso")
    void whenFindVehiclesByRangeOfWeightShouldReturnVehicles() throws IOException {
        // arrange
        IVehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        Vehicle vehicle = new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180km/h", 5, "Gasoline", "Manual", 1.4, 1.8, 1500);
        vehicleRepository.findAll().add(vehicle);  // Agregar un vehículo para el test

        // act
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByRangeOfWeight(1000, 1600);

        // assert
        assertNotNull(vehicles);
        assertEquals(1, vehicles.size());
        assertEquals(1500, vehicles.get(0).getWeight());
    }
}
