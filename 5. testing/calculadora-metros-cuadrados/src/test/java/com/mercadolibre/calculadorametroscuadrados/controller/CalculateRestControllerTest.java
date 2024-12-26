package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testCalculate_validationIndividualFields() throws Exception{
        HouseDTO house = new HouseDTO();
        house.setRooms(List.of(new RoomDTO("R1",10,5),new RoomDTO("R2",20,5)));

        ObjectMapper objectMapper = new ObjectMapper();
        String payloadJson = objectMapper.writeValueAsString(house); // Serializo solo el request


        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(150))
                .andExpect(jsonPath("$.price").value(120000))
                .andExpect(jsonPath("$.biggest.name").value("R2"))
                .andExpect(jsonPath("$.biggest.width").value(20))
                .andExpect(jsonPath("$.biggest.length").value(5));
    }

    @Test
    void testCalculate_validationCompleteJSON() throws Exception{
        HouseDTO house = new HouseDTO();
        house.setRooms(List.of(
                new RoomDTO("R1", 10, 5),
                new RoomDTO("R2", 20, 5)
        ));

        HouseResponseDTO expectedResponse = new HouseResponseDTO();
        expectedResponse.setSquareFeet(150);
        expectedResponse.setPrice(120000);
        expectedResponse.setBiggest(new RoomDTO("R2", 20, 5));
        expectedResponse.setRooms(List.of(
                new RoomDTO("R1", 10, 5),
                new RoomDTO("R2", 20, 5)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(house); // Serializo el request
        String responseJson = writer.writeValueAsString(expectedResponse); // Serializo la respuesta esperada

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));


    }
}
