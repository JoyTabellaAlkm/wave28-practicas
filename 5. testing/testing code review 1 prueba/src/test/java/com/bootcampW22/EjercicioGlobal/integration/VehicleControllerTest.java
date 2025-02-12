package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // Test 1 integration
    @Test
    @DisplayName("Test 1 Integration - Should verify response, type response, request route When find for color and year")
    public void shouldVerifyResponseWhenIsOk () throws Exception{
        // Arrange
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contectTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        String color = "Red";
        int year = 2000;

        List<Vehicle> vehicles = TestUtil.getVehicleListByYearAndColorIntegration();
        List<VehicleDto> response = TestUtil.getVehicleDtoList(vehicles);
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(response));

        //Act && Assert
        mockMvc.perform(get("/vehicles/color/"+color+"/year/"+year))
                .andExpect(statusExpected)
                .andExpect(contectTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }

    // Test 2 integration
    @Test
    @DisplayName("Test 2 Integration - Should return OK when find vehicles for rand and years")
    public void shouldReturnIsOkWhenFIndVehiclesForBrandAndYears() throws Exception{
        // Arrange
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        String brand = "ferrari";
        int startYear = 2000;
        int endYear = 2010;
        List<Vehicle> vehicles = TestUtil.getVehicleListByBrandAndRangeOfYearIntegration();
        List<VehicleDto> response = TestUtil.getVehicleDtoList(vehicles);
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(response));

        // Act && Assert
        mockMvc.perform(get("/vehicles/brand/"+brand+"/between/"+startYear+"/"+endYear))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }

    //Test 3
    @Test
    @DisplayName("Test 3 Integration - Should return Ok When consultation average speed for brand")
    public void shouldReturnIsOkWhenConsultationAverageSpeedForBrand() throws Exception{
        // Arrange
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        String brand = "ferrari";
        VehicleAvgSpeedByBrandDto request = new VehicleAvgSpeedByBrandDto(196.0);
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(request));

        //Act && Assert
        mockMvc.perform(get("/vehicles/average_speed/brand/"+brand))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }

    // Test 4
    @Test
    @DisplayName("Test 4 Integration - Shoul return Ok When Obtain the average ability of people FOR brand")
    public void shouldReturnOkWhenObtainAverageAbilityPeopleForBrand() throws Exception{
        // Arrange
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        String brand = "ferrari";
        VehicleAvgCapacityByBrandDto request = new VehicleAvgCapacityByBrandDto(1.0);
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(request));

        // Act && Assert
        mockMvc.perform(get("/vehicles/average_capacity/brand/"+brand))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }

    // Test 5
    @Test
    @DisplayName("Test 5 Integration - Should return Ok When find vehicles for range of weight")
    public void shouldReturnIsOkWhenFindVehiclesForRangeOfWeight() throws Exception{
        // Arrange
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        List<Vehicle> vehicles = TestUtil.getVehicleListByRangeOfWeightIntegration();
        List<VehicleDto> request = TestUtil.getVehicleDtoList(vehicles);
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(request));

        // Act && Assert
        mockMvc.perform(get("/vehicles/weight")
                        .param("min", "299")
                        .param("max", "300"))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(print());
    }
}
