package com.bootcampW22.EjercicioGlobal.unitTest.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Test
    public void searchAllVehicles_ShouldReturnListOfVehicleDto_WhenVehiclesExist() {
        // Arrange
        List<Vehicle> vehicles = List.of(new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180", 5, "Gasoline", "Automatic", 4.5, 1.8, 1300));
        when(vehicleRepository.findAll()).thenReturn(vehicles);

        // Act
        List<VehicleDto> result = vehicleService.searchAllVehicles();

        // Assert
        assertEquals(1, result.size());
        assertEquals("Toyota", result.get(0).getBrand());
        verify(vehicleRepository, times(1)).findAll();
    }

    @Test
    void searchAllVehicles_ShouldThrowNotFoundException_WhenNoVehiclesExist() {
        // Arrange
        when(vehicleRepository.findAll()).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> vehicleService.searchAllVehicles());
        verify(vehicleRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("1. Buscar vehiculos por color y año")
    void searchVehiclesByYearAndColor_ShouldReturnListOfVehicleDto_WhenVehiclesMatch() {
        // Arrange
        List<Vehicle> vehicles = List.of(new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180.0", 5, "Gasoline", "Automatic", 4.5, 1.8, 1300));
        when(vehicleRepository.findVehiclesByYearAndColor("Red", 2020)).thenReturn(vehicles);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor("Red", 2020);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Red", result.get(0).getColor());
        verify(vehicleRepository, times(1)).findVehiclesByYearAndColor("Red", 2020);
    }

    @Test
    @DisplayName("1. Buscar vehiculos por color y año cuando no hace match")
    void searchVehiclesByYearAndColor_ShouldThrowNotFoundException_WhenNoVehiclesMatch() {
        // Arrange
        when(vehicleRepository.findVehiclesByYearAndColor("Blue", 2021)).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByYearAndColor("Blue", 2021));
        verify(vehicleRepository, times(1)).findVehiclesByYearAndColor("Blue", 2021);
    }

    @Test
    @DisplayName("2. Buscar vehículos por marca y rango de años")
    void searchVehiclesByBrandAndRangeOfYear_ReturnsListOfVehicles_WhenVehiclesExist() {
        // Arrange
        String brand = "Toyota";
        int startYear = 2010;
        int endYear = 2020;

        List<Vehicle> vehicles = List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180.0", 5, "Gasoline", "Automatic", 4.5, 1.8, 1300),
                new Vehicle(2L, "Toyota", "Camry", "DEF456", "Blue", 2019, "200.0", 4, "Gasoline", "Automatic", 4.8, 1.9, 1500)
        );

        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear))
                .thenReturn(vehicles);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Corolla", result.get(0).getModel());
        assertEquals("Camry", result.get(1).getModel());
        verify(vehicleRepository, times(1)).findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);
    }

    @Test
    @DisplayName("2. Buscar vehículos por marca y rango de años cuando no existe")
    void searchVehiclesByBrandAndRangeOfYear_ThrowsNotFoundException_WhenNoVehiclesFound() {
        // Arrange
        String brand = "Honda";
        int startYear = 2000;
        int endYear = 2010;

        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear)
        );

        assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());
        verify(vehicleRepository, times(1)).findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);
    }

    @Test
    @DisplayName("3. Consultar velocidad promedio por marca")
    void calculateAvgSpeedByBrand_ShouldReturnAverageSpeed_WhenVehiclesMatch() {
        // Arrange
        List<Vehicle> vehicles = List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180.0", 5, "Gasoline", "Automatic", 4.5, 1.8, 1300),
                new Vehicle(2L, "Toyota", "Camry", "DEF456", "Blue", 2019, "200.0", 5, "Gasoline", "Automatic", 4.8, 1.9, 1500)
        );
        when(vehicleRepository.findVehiclesByBrand("Toyota")).thenReturn(vehicles);

        // Act
        VehicleAvgSpeedByBrandDto result = vehicleService.calculateAvgSpeedByBrand("Toyota");

        // Assert
        assertEquals(190.0, result.getAverage_speed());
        verify(vehicleRepository, times(1)).findVehiclesByBrand("Toyota");
    }

    @Test
    @DisplayName("3. Consultar velocidad promedio por marca cuando el vehiculo no es encontrado")
    void calculateAvgSpeedByBrand_ShouldThrowNotFoundException_WhenNoVehiclesMatch() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrand("Honda")).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> vehicleService.calculateAvgSpeedByBrand("Honda"));
        verify(vehicleRepository, times(1)).findVehiclesByBrand("Honda");
    }

    @Test
    @DisplayName("4. Obtener la capacidad promedio de personas por marca")
    void calculateAvgCapacityByBrand_ShouldReturnAverageCapacity_WhenVehiclesMatch() {
        // Arrange
        List<Vehicle> vehicles = List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180.0", 5, "Gasoline", "Automatic", 4.5, 1.8, 1300),
                new Vehicle(2L, "Toyota", "Camry", "DEF456", "Blue", 2019, "200.0", 4, "Gasoline", "Automatic", 4.8, 1.9, 1500)
        );
        when(vehicleRepository.findVehiclesByBrand("Toyota")).thenReturn(vehicles);

        // Act
        VehicleAvgCapacityByBrandDto result = vehicleService.calculateAvgCapacityByBrand("Toyota");

        // Assert
        assertEquals(4.5, result.getAverage_capacity());
        verify(vehicleRepository, times(1)).findVehiclesByBrand("Toyota");
    }

    @Test
    @DisplayName("4. Obtener la capacidad promedio de personas por marca cuando no es encontrado")
    void calculateAvgCapacityByBrand_ShouldThrowNotFoundException_WhenNoVehiclesMatch() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrand("Ford")).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> vehicleService.calculateAvgCapacityByBrand("Ford"));
        verify(vehicleRepository, times(1)).findVehiclesByBrand("Ford");
    }

    @Test
    @DisplayName("5. Listar vehículos por rango de peso")
    void searchVehiclesByRangeOfWeight_ShouldReturnListOfVehicleDto_WhenVehiclesMatch() {
        // Arrange
        List<Vehicle> vehicles = List.of(new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180.0", 5, "Gasoline", "Automatic", 4.5, 1.8, 1300));
        when(vehicleRepository.findVehiclesByRangeOfWeight(1200, 1400)).thenReturn(vehicles);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByRangeOfWeight(1200, 1400);

        // Assert
        assertEquals(1, result.size());
        assertEquals(1300, result.get(0).getWeight());
        verify(vehicleRepository, times(1)).findVehiclesByRangeOfWeight(1200, 1400);
    }

    @Test
    @DisplayName("5. Listar vehículos por rango de peso cuando no es encontrado")
    void searchVehiclesByRangeOfWeight_ShouldThrowNotFoundException_WhenNoVehiclesMatch() {
        // Arrange
        when(vehicleRepository.findVehiclesByRangeOfWeight(500, 1000)).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByRangeOfWeight(500, 1000));
        verify(vehicleRepository, times(1)).findVehiclesByRangeOfWeight(500, 1000);
    }


}
