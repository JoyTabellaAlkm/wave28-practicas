package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();


    @Test
    void calculateIntegrationTest() throws Exception {
        RoomDTO room1 = new RoomDTO("Living", 10, 10);
        RoomDTO room2 = new RoomDTO("Kitchen", 1, 20);
        RoomDTO room3 = new RoomDTO("Garden", 100, 100);
        HouseDTO house = new HouseDTO("House", "Calle 123", List.of(room1, room2, room3));

        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);
        expectedResponse.setSquareFeet(10*10 + 20 + 100*100);
        expectedResponse.setBiggest(room3);
        expectedResponse.setPrice(800*expectedResponse.getSquareFeet());

        String reqBody = writer.writeValueAsString(house);
        String expectedResponseBody = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reqBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(expectedResponseBody));
    }
}
