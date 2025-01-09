package com.mercadolibre.calculadorametroscuadrados.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

public class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("Debe calcular los pies cuadrados de una casa")
    public void shouldCalculateSquareFeetForARoom() {
        // arrange
        RoomDTO room1 = new RoomDTO();
        room1.setName("Cuarto 1");
        room1.setWidth(20);
        room1.setLength(20);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Cuarto 2");
        room2.setWidth(10);
        room2.setLength(20);

        HouseDTO req = new HouseDTO();
        req.setName("Casa");
        req.setAddress("Calle Falsa # 123");
        req.setRooms(List.of(room1, room2));

        HouseResponseDTO expected = new HouseResponseDTO(req);
        expected.setSquareFeet(20*20 + 10*20);
        expected.setBiggest(room1);
        expected.setPrice(expected.getSquareFeet() * 800);

        // act
        HouseResponseDTO res = calculateService.calculate(req);

        // assert
        assertEquals(expected.getName(), res.getName());
        assertEquals(expected.getAddress(), res.getAddress());
        assertEquals(expected.getBiggest(), res.getBiggest());
        assertEquals(expected.getSquareFeet(), res.getSquareFeet());
        assertEquals(expected.getPrice(), res.getPrice());
        assertIterableEquals(expected.getRooms(), res.getRooms());
    }

}
