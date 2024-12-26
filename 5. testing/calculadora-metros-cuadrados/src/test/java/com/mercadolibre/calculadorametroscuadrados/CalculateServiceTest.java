package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class CalculateServiceTest {
    private static CalculateService calculateService;


    @BeforeAll
    public static void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    public void calculate_house_with_no_rooms() {
        HouseDTO houseDTO = new HouseDTO("Casa 1", "Calle 123", new ArrayList<>());

        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        Assertions.assertEquals("Casa 1", houseResponseDTO.getName());
        Assertions.assertEquals("Calle 123", houseResponseDTO.getAddress());
        Assertions.assertEquals(new ArrayList<>(), houseResponseDTO.getRooms());
        Assertions.assertEquals(0, houseResponseDTO.getPrice());
        Assertions.assertEquals(0, houseResponseDTO.getRooms().size());
        Assertions.assertEquals(0, houseResponseDTO.getSquareFeet());
        Assertions.assertNull(houseResponseDTO.getBiggest());
    }

    @Test
    public void calculate_house_with_two_rooms() {
        RoomDTO biggestRoom = new RoomDTO("Cuarto", 20, 20);
        List<RoomDTO> rooms = new ArrayList<>(List.of(
                new RoomDTO("Baño", 10, 10),
                biggestRoom));

        HouseDTO houseDTO = new HouseDTO("Casa 2", "Calle 555", rooms);

        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        Assertions.assertEquals("Casa 2", houseResponseDTO.getName());
        Assertions.assertEquals("Calle 555", houseResponseDTO.getAddress());
        Assertions.assertEquals(rooms, houseResponseDTO.getRooms());
        Assertions.assertEquals(400000, houseResponseDTO.getPrice());
        Assertions.assertEquals(2, houseResponseDTO.getRooms().size());
        Assertions.assertEquals(500, houseResponseDTO.getSquareFeet());
        Assertions.assertEquals(biggestRoom, houseResponseDTO.getBiggest());
        Assertions.assertEquals(100, houseResponseDTO.getRooms().get(0).getSquareFeet());
        Assertions.assertEquals(400, houseResponseDTO.getRooms().get(1).getSquareFeet());
    }
}
