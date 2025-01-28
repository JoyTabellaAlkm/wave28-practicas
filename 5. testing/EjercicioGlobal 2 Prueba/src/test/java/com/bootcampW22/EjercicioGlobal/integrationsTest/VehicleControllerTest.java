package com.bootcampW22.EjercicioGlobal.integrationsTest;

import com.bootcampW22.EjercicioGlobal.controller.VehicleController;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Should return all vehicles when found")
    public void shouldReturnAllVehiclesWhenFound() throws Exception {
        // arrange
        List<VehicleDto> vehicleList = Arrays.asList(
                new VehicleDto(1L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8),
                new VehicleDto(2L, "Buick", "LeSabre", "81962", "Green", 2005, "240", 6, "gasoline", "semi-automatic", 207.93, 125.94, 199.22),
                new VehicleDto(3L, "Mitsubishi", "Excel", "0904", "Green", 1987, "89", 5, "gas", "automatic", 39.18, 290.82, 121.17),
                new VehicleDto(4L, "Toyota", "4Runner", "496", "Puce", 1994, "127", 1, "gas", "automatic", 251.59, 121.06, 65.19),
                new VehicleDto(5L, "Lexus", "LS", "03857", "Orange", 2003, "159", 3, "diesel", "automatic", 9.49, 118.21, 168.54)

        );
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(vehicleList));

        // act & assert
        mockMvc.perform(get("/vehicles"))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("1. Buscar vehiculos por color y año")
    public void shouldReturnVehiclesByColorAndYearWhenFound() throws Exception {
        // arrange
        String color = "Mauv";
        int year = 1986;
        List<VehicleDto> vehicleList = Arrays.asList(
                new VehicleDto(1L, "Pontiac", "Fiero", "6603", "Mauv", 1986, "85", 2, "gasoline", "semi-automatic", 105.43, 280.28, 288.8)
        );
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(vehicleList));

        // act & assert
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("2. Buscar vehículos por marca y rango de años")
    public void shouldReturnVehiclesByBrandAndYearRangeWhenFound() throws Exception {
        // arrange
        String brand = "Mitsubishi";
        int startYear = 1980;
        int endYear = 2015;
        List<VehicleDto> vehicleList = Arrays.asList(
                new VehicleDto(3L, "Mitsubishi", "Excel", "0904", "Green", 1987, "89", 5, "gas", "automatic", 39.18, 290.82, 121.17)
        );
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(vehicleList));

        // act & assert
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", brand, startYear, endYear))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("3. Consultar velocidad promedio por marca")
    public void shouldReturnAverageSpeedByBrandWhenVehiclesAreFound() throws Exception {
        // arrange
        String brand = "Mitsubishi";
        VehicleAvgSpeedByBrandDto avgSpeedByBrand = new VehicleAvgSpeedByBrandDto(89.0);
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(avgSpeedByBrand));

        // act & assert
        mockMvc.perform(get("/vehicles/average_speed/brand/" + brand))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());

    }

    @Test
    @DisplayName("4. Obtener la capacidad promedio de personas por marca")
    public void shouldReturnAverageCapacityByBrandWhenVehiclesAreFound() throws Exception {
        // arrange
        String brand = "Mitsubishi";
        VehicleAvgCapacityByBrandDto avgCapacityByBrand = new VehicleAvgCapacityByBrandDto(5.0);
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(avgCapacityByBrand));

        // act & assert
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", brand))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }

    @Test
    @DisplayName("5. Listar vehículos por rango de peso")
    public void shouldReturnVehiclesByRangeOfWeightWhenFound() throws Exception {
        // arrange
        double minWeight = 100.0;
        double maxWeight = 200.0;
        List<VehicleDto> vehicleList = Arrays.asList(
                new VehicleDto(2L, "Buick", "LeSabre", "81962", "Green", 2005, "240", 6, "gasoline", "semi-automatic", 207.93, 125.94, 199.22),
                new VehicleDto(3L, "Mitsubishi", "Excel", "0904", "Green", 1987, "89", 5, "gas", "automatic", 39.18, 290.82, 121.17),
                new VehicleDto(5L, "Lexus", "LS", "03857", "Orange", 2003, "159", 3, "diesel", "automatic", 9.49, 118.21, 168.54)

        );
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(vehicleList));

        // act & assert
        mockMvc.perform(get("/vehicles/weight")
                        .param("min", String.valueOf(minWeight))
                        .param("max", String.valueOf(maxWeight)))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }



}