package com.bootcampW22.EjercicioGlobal.unit.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.bootcampW22.EjercicioGlobal.utils.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {
    @Mock
    private VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    //test 1
    @Test
    @DisplayName("Should return all vehicles with equals color and year")
    public void shouldReturnAllVehiclesWithEquealsColorAndYear(){
        // Arrange
        String color = "Red";
        int year = 2000;
        List<Vehicle> vehicles = TestUtil.getVehicleListByYearAndColor();
        List<VehicleDto> expectedResult = TestUtil.getVehicleDtoList(vehicles);

        // Act
        when(vehicleRepository.findVehiclesByYearAndColor(color,year)).thenReturn(vehicles);
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor(color, year);
        // Assert
        assertEquals(expectedResult, result, "Se esperaba que fueran iguales");

    }

    @Test
    @DisplayName("Should return NotFound exception when Not find vehicles")
    public void shouldReturnNotfoundExceptionWhenNotFindVecles(){
        // Arrange
        String color = "Black";
        int year = 2000;
        String messageExpected = "No se encontraron vehículos con esos criterios.";

        // Act
        Exception exception = assertThrows(NotFoundException.class, () -> {
            vehicleService.searchVehiclesByYearAndColor(color, year);
        });

        //Assert
        assertEquals(messageExpected, exception.getMessage(), "Se esperaba que fueran iguales");
    }

    // Test 2
    @Test
    @DisplayName("Find vechicles Should return vehicles for brand and year range")
    public void findVehiclesShouldReturnVehiclesForBrandAndYear(){
        // Arrange
        String brand = "Ferrari";
        int year = 2004;
        List<Vehicle> vehicles = TestUtil.getVehicleListByBrandAndRangeOfYear();
        List<VehicleDto> espectedRestult = TestUtil.getVehicleDtoList(vehicles);

        // Act
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand,year, year+10)).thenReturn(vehicles);
        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, year, year+10);

        // Assert
        assertEquals(espectedRestult, result);

    }

    @Test
    @DisplayName("Find vehicles for brand and year Should return exception when don't find")
    public void ShouldReturnExceptionWhenDontFind(){
        // Arrange
        int year = 2000;
        String brand = "mercedes";
        String resultExpected = "No se encontraron vehículos con esos criterios.";

        //Act
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, year, year+10)).thenReturn(TestUtil.getVehicleListEmpty());
        Exception exception = assertThrows(NotFoundException.class, () -> {
            vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, year, year+10);
        });

        // Assert
        assertEquals(resultExpected, exception.getMessage(), "Se esperaba que fueran iguales.");
    }

    // Test 3
    @Test
    @DisplayName("Test 3 - Should return average speed when find brand")
    public void shouldReturnAverageSpeedWhenFindBrand(){
        // Arrange
        String brand = "Ferrari";
        List<Vehicle> vehicles = TestUtil.getVehicleListByBrand();

        VehicleAvgSpeedByBrandDto resultExpected = new VehicleAvgSpeedByBrandDto(122.5);

        // Act
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicles);
        VehicleAvgSpeedByBrandDto result = vehicleService.calculateAvgSpeedByBrand(brand);

        // Assert
        assertEquals(resultExpected, result, "Se esperaba que fueran iguales.");
    }

    @Test
    @DisplayName("Test 3 - Should return NotFoundException when the list is empty")
    public void shouldReturnNotFoundExceptionWhenListIsEmpty(){
        // Arrange
        String brand = "Mercedes";
        List<Vehicle> vehicles = TestUtil.getVehicleListEmpty();
        String resultExpected = "No se encontraron vehículos de esa marca.";

        // Act
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicles);
        Exception exception = assertThrows(NotFoundException.class, () -> {
            vehicleService.calculateAvgSpeedByBrand(brand);
        });

        // Assert
        assertEquals(resultExpected, exception.getMessage(), "Se esperaba que fueran iguales.");
    }

    // Test 4
    @Test
    @DisplayName("Test 4 - Should return average capacity when find brand")
    public void shouldReturnAverageCapacityWhenFindBrand(){
        // Arrange
        String brand = "Ferrari";
        List<Vehicle> vehicles = TestUtil.getVehicleListByBrand();
        VehicleAvgCapacityByBrandDto resultExpected = new VehicleAvgCapacityByBrandDto(3.0);

        // Act
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicles);
        VehicleAvgCapacityByBrandDto result = vehicleService.calculateAvgCapacityByBrand(brand);

        // Assert
        assertEquals(resultExpected, result, "Se esperaba que fueran iguales");
    }

    @Test
    @DisplayName("Test 4 - should return NotFoundException when find for brand")
    public void shouldReturnNotFoundExceptionWhenFindBrand(){
        // Arrange
        String brand = "Mercedes";
        List<Vehicle> vehicles = TestUtil.getVehicleListEmpty();
        String resultExpected = "No se encontraron vehículos de esa marca.";

        // Act
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicles);
        Exception exception = assertThrows(NotFoundException.class, () -> {
            vehicleService.calculateAvgCapacityByBrand(brand);
        });

        // Assert
        assertEquals(resultExpected, exception.getMessage(), "Se esperaba que fueran iguales.");
    }

    // Test 5
    @Test
    @DisplayName("Test 5 - should return list of vehicles when find range of weith")
    public void shouldReturnListOfVehiclesWhenFindRangeOfWeith(){
        // Arrange
        double maxWeight = 250.0;
        double minWeight = 350.0;
        List<Vehicle> vehicles = TestUtil.getVehicleListByRangeOfWeight();
        List<VehicleDto> resultExpected = TestUtil.getVehicleDtoList(vehicles);

        // Act
        when(vehicleRepository.findVehiclesByRangeOfWeight(maxWeight, minWeight)).thenReturn(vehicles);
        List<VehicleDto> result = vehicleService.searchVehiclesByRangeOfWeight(maxWeight, minWeight);

        // Assert
        assertEquals(resultExpected, result, "Se esperaba que fueran iguales");
    }

    @Test
    @DisplayName("Test 5 - Should return NotFoundException when find for weight")
    public void shouldReturnNotFoundExceptionWhenFIndForWeight(){
        // Arrange
        double maxWeight = 250.0;
        double minWeight = 350.0;
        List<Vehicle> vehicles = TestUtil.getVehicleListEmpty();
        String resultExpected = "No se encontraron vehículos en ese rango de peso.";

        // Act
        when(vehicleRepository.findVehiclesByRangeOfWeight(maxWeight, minWeight)).thenReturn(vehicles);
        Exception exception = assertThrows(NotFoundException.class, () -> {
            vehicleService.searchVehiclesByRangeOfWeight(maxWeight, minWeight);
        });

        // assert
        assertEquals(resultExpected, exception.getMessage(), "Se esperaba que fueran iguales.");
    }
}
