package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CalculateServiceTests {

    @Autowired
    CalculateService calculateService;
    HouseDTO house;

    @BeforeEach
    void createHouse() {
        RoomDTO room1 = new RoomDTO("Living", 10, 20);
        RoomDTO room2 = new RoomDTO("Kitchen", 1, 20);
        RoomDTO room3 = new RoomDTO("Garden", 100, 100);
        house = new HouseDTO("House", "Calle 123", List.of(room1, room2, room3));
    }

    @Test
    void calculateSquareFeet() {
        RoomDTO room = new RoomDTO("Living", 10, 20);
        HouseDTO house = new HouseDTO("House", "Calle 123", List.of(room));

        HouseResponseDTO result = calculateService.calculate(house);
        Assertions.assertEquals(10*20, result.getSquareFeet());
    }

    @Test
    void calculateSquareFeetOfHouseWithMultipleRooms() {
        HouseResponseDTO result = calculateService.calculate(house);
        Assertions.assertEquals(10*20+20+100*100, result.getSquareFeet());
    }

    @Test
    void calculatePriceOfHouseWithMultipleRooms() {
        HouseResponseDTO result = calculateService.calculate(house);
        Assertions.assertEquals(result.getSquareFeet()*800, result.getPrice());
    }

    @Test
    void calculateBiggestRoomOfHouseWithMultipleRooms() {
        HouseResponseDTO result = calculateService.calculate(house);
        Assertions.assertEquals(house.getRooms().get(2), result.getBiggest());
    }
}
