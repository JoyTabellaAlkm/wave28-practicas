package com.bootcampW22.EjercicioGlobal.unit;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTests {

    @Mock
    VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Test
    @DisplayName("01.1 - Buscar vehiculos por color y año")
    public void SearchVehiclesByYearAnColor() {
        //Arrange
        String color = "Red";
        int year = 2020;
        List<VehicleDto> esperado = List.of(
                new VehicleDto(1L, "Ford", "Accord", "09", "Red", 2005, "240", 1, "gas", "automatic", 107.71, 54.82, 1000.50),
                new VehicleDto(2L, "Ford", "Accord", "10", "Blue", 2005, "165", 2, "gas", "automatic", 108.71, 55.82, 1100.10)
        );
        List<Vehicle> vehicles = List.of(
                new Vehicle(1L, "Ford", "Accord", "09", "Red", 2005, "240", 1, "gas", "automatic", 107.71, 54.82, 1000.50),
                new Vehicle(2L, "Ford", "Accord", "10", "Blue", 2005, "165", 2, "gas", "automatic", 108.71, 55.82, 1100.10)
        );

        when(vehicleRepository.findVehiclesByYearAndColor(anyString(), anyInt())).thenReturn(vehicles);

        //Act
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor(color, year);

        //Assert
        assertEquals(esperado, result);

    }

     @Test
     @DisplayName("01.2-No se encontraron vehículos con esos criterios")
     void SearchVehiclesByYearAndColor(){
        //Arrange
         String color="Red";
         int year=2020;
         List <Vehicle> vehicles= Collections.emptyList();
         when(vehicleRepository.findVehiclesByYearAndColor(anyString(),anyInt())).thenReturn(vehicles);

         //Act y Assert

         assertThrows(NotFoundException.class,()->vehicleService.searchVehiclesByYearAndColor(color,year));


     }


    @Test
    @DisplayName("02.1 - Buscar vehiculos por marca y rango de años")
    public void SearchVehiclesByBrandAndRangeOfYears() {
        // Arrange
        String brand = "Ford";
        int start_year = 2010;
        int end_year = 2020;
        List<VehicleDto> esperado = List.of(
                new VehicleDto(1L, "Ford", "Accord", "09", "Red", 2011, "240", 1, "gas", "automatic", 107.71, 54.82, 1000.50),
                new VehicleDto(2L, "Ford", "Accord", "10", "Blue", 2019, "165", 2, "gas", "automatic", 108.71, 55.82, 1100.10)
        );
        List<Vehicle> vehicles = List.of(
                new Vehicle(1L, "Ford", "Accord", "09", "Red", 2011, "240", 1, "gas", "automatic", 107.71, 54.82, 1000.50),
                new Vehicle(2L, "Ford", "Accord", "10", "Blue", 2019, "165", 2, "gas", "automatic", 108.71, 55.82, 1100.10)
        );

        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(anyString(), anyInt(), anyInt())).thenReturn(vehicles);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, start_year, end_year);

        assertEquals(esperado, result);

    }

     @Test
     @DisplayName("2.2 - No se encontraron vehículos con esos criterios.")
     void SearchVehiclesByBrandAndRangeOfYears_NotFound(){
        //Arrange
         String brand="Ford";
         int start_year = 2010;
         int end_year = 2020;

         List <Vehicle> vehicles=Collections.emptyList();
         when (vehicleRepository.findVehiclesByBrandAndRangeOfYear(anyString(),anyInt(),anyInt())).thenReturn(vehicles);

         //Act and Assert
         assertThrows(NotFoundException.class,()->vehicleService.searchVehiclesByBrandAndRangeOfYear(brand,start_year,end_year));


     }



    @Test
    @DisplayName("03.1 - Calcular el promedio de velocidad por marca")
    public void CalculateAvgSpeedByBrand() {
        //Arrange
        String brand = "Toyota";
        VehicleAvgSpeedByBrandDto esperado = new VehicleAvgSpeedByBrandDto(235.0);
        List<Vehicle> vehicles = List.of(
                new Vehicle(1L, "Toyota", "Hi lux", "09", "Red", 2011, "240", 1, "gas", "automatic", 107.71, 54.82, 258.28),
                new Vehicle(2L, "Toyota", "Hi lux", "10", "Blue", 2019, "230", 2, "gas", "automatic", 108.71, 55.82, 259.28)
        );

        when(vehicleRepository.findVehiclesByBrand(anyString())).thenReturn(vehicles);

        //Act
        VehicleAvgSpeedByBrandDto result = vehicleService.calculateAvgSpeedByBrand(brand);

        //Assert
        assertEquals(esperado, result);
    }

    @Test
    @DisplayName("03.2- No se encontraron vehículos de esa marca")
    void CalculateAvgSpeedByBrand_Notfound(){
        //Arrange
        String brand="Ford";
        List <Vehicle> vehicles=Collections.emptyList();
        when(vehicleRepository.findVehiclesByBrand(anyString())).thenReturn(vehicles);

        //Act y Assert
        assertThrows(NotFoundException.class,()->{
            vehicleService.calculateAvgSpeedByBrand(brand);
        });

    }


    @Test
    @DisplayName("04.1 - Calcular el promedio de capacidad por marca")
    public void CalculateAvgCapacityByBrand() {
        //Arrange
        String brand = "Ford";
        VehicleAvgCapacityByBrandDto esperado = new VehicleAvgCapacityByBrandDto(1);
        List<Vehicle> vehicles = List.of(
                new Vehicle(1L, "Ford", "Accord", "09", "Red", 2011, "240", 1, "gas", "automatic", 107.71, 54.82, 258.28),
                new Vehicle(2L, "Ford", "Accord", "10", "Blue", 2019, "165", 1, "gas", "automatic", 108.71, 55.82, 259.28)
        );
        when(vehicleRepository.findVehiclesByBrand(anyString())).thenReturn(vehicles);

        //Act
        VehicleAvgCapacityByBrandDto result = vehicleService.calculateAvgCapacityByBrand(brand);

        //Assert
        assertEquals(esperado, result);
    }

@Test
@DisplayName("04.2-  No se encontraron vehículos de esa marca")
void CalculateAvgCapacityByBrand_NotFound(){
      //Arrange
    String brand="Ford";
    List <Vehicle> vehicles= Collections.emptyList();

    when(vehicleRepository.findVehiclesByBrand(anyString())).thenReturn(vehicles);

    //Act y Assert
    assertThrows(NotFoundException.class,()->{
        vehicleService.calculateAvgCapacityByBrand(brand);
    });

}

@Test
@DisplayName("05.1 - Buscar vehiculos dentro de un rango de peso")
    public void  SearchVehicleByRangeOfWeight(){
      //Arrange
    double weight_min=1000.0;
    double weight_max=1400.0;
    List<VehicleDto> esperado= List.of(
            new VehicleDto(1L,"Ford","Accord","09","Red",2011,"240",1,"gas","automatic",107.71,54.82,1000.50),
            new VehicleDto(2L,"Ford","Accord","10","Blue",2019,"165",2,"gas","automatic",108.71,55.82,1100.10)
    );
    List<Vehicle> vehicles=List.of(
            new Vehicle(1L,"Ford","Accord","09","Red",2011,"240",1,"gas","automatic",107.71,54.82,1000.50),
            new Vehicle(2L,"Ford","Accord","10","Blue",2019,"165",2,"gas","automatic",108.71,55.82,1100.10)
    );
            when(vehicleRepository.findVehiclesByRangeOfWeight(anyDouble(),anyDouble())).thenReturn(vehicles);

    //Act
    List<VehicleDto> result= vehicleService.searchVehiclesByRangeOfWeight(weight_min,weight_max);

    //Assert
    assertEquals(esperado,result);
}
@Test
@DisplayName("05.2 -  No se encontraron vehiculos para ese rango de peso")
void SearchVehicleByRangeOfWeight_NotFound(){
      //Arrange
    List<Vehicle> vehicles=Collections.emptyList();
    double weight_min=1000.0;
    double weight_max=1400.0;
    when(vehicleRepository.findVehiclesByRangeOfWeight(anyDouble(),anyDouble())).thenReturn(vehicles);

    //Act y Assert
    assertThrows(NotFoundException.class,()->vehicleService.searchVehiclesByRangeOfWeight(weight_min,weight_max));

}


}
