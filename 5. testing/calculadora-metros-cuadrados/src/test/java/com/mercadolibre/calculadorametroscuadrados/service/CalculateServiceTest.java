package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {
    private final CalculateService calculateService = new CalculateService();

    HouseDTO houseDTO;
    HouseResponseDTO houseResponseDTO;
    @BeforeEach
    void setUp(){houseDTO = new HouseDTO();}
    @Test
    void testCalculate_SingleRoom() {
        houseDTO.setRooms(List.of(new RoomDTO("R1",10,5)));

        houseResponseDTO = calculateService.calculate(houseDTO);
        assertEquals(50,houseResponseDTO.getSquareFeet());
        assertEquals(40000,houseResponseDTO.getPrice());
    }
    @Test
    void testCalculate_MultipleRoom(){
        houseDTO.setRooms(List.of(new RoomDTO("R1",10,5), //50
                new RoomDTO("R2",20,5), //100
                new RoomDTO("R3",5,5) //25
                ));
        houseResponseDTO = calculateService.calculate(houseDTO);
        assertEquals(175,houseResponseDTO.getSquareFeet());
        assertEquals(140000,houseResponseDTO.getPrice());
        assertEquals("R2",houseResponseDTO.getBiggest().getName());
    }
    @Test
    void testCalculate_WithEmptyRooms() {
        // Arrange
        houseDTO.setRooms(List.of());
        // Act
        HouseResponseDTO response = calculateService.calculate(houseDTO);

        // Assert
        assertNotNull(response);
        assertEquals(0, response.getSquareFeet());
        assertEquals(0, response.getPrice());
        assertNull(response.getBiggest()); }
}
