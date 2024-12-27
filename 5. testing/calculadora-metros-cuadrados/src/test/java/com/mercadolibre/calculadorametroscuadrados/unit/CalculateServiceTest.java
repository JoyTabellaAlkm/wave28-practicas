package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.factory.RoomFactory;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateServiceTest {
    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    public void itCalculatesCorrectlyWithEmptyRooms() {
        HouseDTO house = new HouseDTO();
        house.setRooms(Collections.emptyList());
        Integer expectedSquareFeet = 0;
        Integer expectedPrice = 0;

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(expectedSquareFeet, response.getSquareFeet());
        assertNull(response.getBiggest());
        assertEquals(expectedPrice, response.getPrice());
    }

    @Test
    public void itCalculatesCorrectlyWithOneRoom() {
        RoomDTO bigRoom = RoomFactory.createBigRoomDTO();

        HouseDTO house = new HouseDTO();
        house.setRooms(List.of(bigRoom));

        Integer expectedSquareFeet = 80000;
        Integer expectedPrice = expectedSquareFeet * 800;

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(expectedSquareFeet, response.getSquareFeet());
        assertEquals(bigRoom, response.getBiggest());
        assertEquals(expectedPrice, response.getPrice());
    }

    @Test
    public void itCalculatesCorrectlyWithMultipleRoom() {
        RoomDTO bigRoom = RoomFactory.createBigRoomDTO();
        RoomDTO mediumRoom = RoomFactory.createMediumRoomDTO();
        RoomDTO smallRoom = RoomFactory.createSmallRoomDTO();

        HouseDTO house = new HouseDTO();
        house.setRooms(List.of(bigRoom, smallRoom, mediumRoom));

        Integer expectedSquareFeet = 115000;
        Integer expectedPrice = expectedSquareFeet * 800;

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(expectedSquareFeet, response.getSquareFeet());
        assertEquals(bigRoom, response.getBiggest());
        assertEquals(expectedPrice, response.getPrice());
    }
}
