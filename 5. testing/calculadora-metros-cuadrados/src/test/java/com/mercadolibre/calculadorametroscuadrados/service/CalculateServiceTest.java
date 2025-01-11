package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    void calculate() {
        // Arrange
        HouseDTO houseDTO = getPepeHouseDTO();
        Integer expectedResult = 86;
        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);
        // Assert
        assertEquals(expectedResult, result.getSquareFeet());
    }


    @Test
    void calculatePrice() {
        // Arrange
        HouseDTO houseDTO = getPepeHouseDTO();
        Integer expectedPrice = 68800;
        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);
        // Assert
        assertEquals(expectedPrice, result.getPrice());
    }

    @Test
    void calculateBiggestRoom() {
        // Arrange
        HouseDTO houseDTO = getPepeHouseDTO();
        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);
        // Assert
        assertEquals(8, result.getBiggest().getLength());
        assertEquals(5, result.getBiggest().getWidth());
    }

    private RoomDTO getRoomDTO(String name, int length, int width) {
        return new RoomDTO(name, length, width);
    }

    private HouseDTO getPepeHouseDTO() {
        HouseDTO houseDTO = new HouseDTO("Casa de Pepe", "Av. Pepon 123", new ArrayList<>());
        houseDTO.getRooms().add(getRoomDTO("Cuarto 1", 5, 5));
        houseDTO.getRooms().add(getRoomDTO("Cuarto 2", 8, 5));
        houseDTO.getRooms().add(getRoomDTO("Cocina", 3, 4));
        houseDTO.getRooms().add(getRoomDTO("Baño", 3, 3));
        return houseDTO;
    }
}