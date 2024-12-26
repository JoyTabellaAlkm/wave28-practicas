package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    HouseDTO houseDTO;

    @BeforeEach
    void setUp() {
        RoomDTO r1 = new RoomDTO();
        r1.setLength(10);
        r1.setWidth(10);

        RoomDTO r2 = new RoomDTO();
        r2.setLength(15);
        r2.setWidth(18);

        houseDTO = new HouseDTO();
        houseDTO.setRooms(List.of(r1, r2));
    }

    @Test
    @DisplayName("Verifica que se calcula correctamente el precio de la propiedad.")
    void verifyCalculateHouseValue() {

        // ARRANGE
        Integer price = 296000;

        // ACT
        HouseResponseDTO actual = calculateService.calculate(houseDTO);

        // ASSERT
        assertEquals(price, actual.getPrice());

    }

    @Test
    @DisplayName("Verifica que la habitación con las mayores dimensiones sea la más grande")
    void verifyBiggestRoom() {

        // ARRANGE
        RoomDTO expectedBiggest = houseDTO.getRooms().get(1);

        // ACT
        HouseResponseDTO actual = calculateService.calculate(houseDTO);
        RoomDTO actualBiggest = actual.getBiggest();

        // ASSERT
        assertEquals(expectedBiggest, actualBiggest);

    }

    @Test
    @DisplayName("Verificar la cantidad de metros cuadrados por habitación")
    void name() {

        // ARRANGE
        Integer expectedR1Sqft = 100;
        Integer expectedR2Sqft = 270;

        // ACT
        HouseDTO actualHouse = calculateService.calculate(houseDTO);

        Integer actualR1Sqft = actualHouse.getRooms().get(0).getSquareFeet();
        Integer actualR2Sqft = actualHouse.getRooms().get(1).getSquareFeet();

        // ASSERT
        assertEquals(expectedR1Sqft, actualR1Sqft);
        assertEquals(expectedR2Sqft, actualR2Sqft);

    }
}