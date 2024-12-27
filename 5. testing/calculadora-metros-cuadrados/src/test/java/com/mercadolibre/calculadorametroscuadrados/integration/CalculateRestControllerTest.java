package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.factory.RoomFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testCalculateWithEmptyRooms() throws Exception {
        HouseDTO house = new HouseDTO();
        house.setRooms(Collections.emptyList());

        Integer expectedSquareFeet = 0;
        Integer expectedPrice = 0;

        mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet", is(expectedSquareFeet)))
                .andExpect(jsonPath("$.biggest", is(nullValue())))
                .andExpect(jsonPath("$.price", is(expectedPrice)));
    }

    @Test
    void testCalculateWithOneRoom() throws Exception {
        RoomDTO bigRoom = RoomFactory.createBigRoomDTO();

        HouseDTO house = new HouseDTO();
        house.setRooms(List.of(bigRoom));

        Integer expectedSquareFeet = 80000;
        Integer expectedPrice = expectedSquareFeet * 800;

        mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet", is(expectedSquareFeet)))
                .andExpect(jsonPath("$.biggest.squareFeet", is(expectedSquareFeet)))
                .andExpect(jsonPath("$.price", is(expectedPrice)));
    }

    @Test
    void testCalculateWithMultipleRooms() throws Exception {
        RoomDTO bigRoom = RoomFactory.createBigRoomDTO();
        RoomDTO mediumRoom = RoomFactory.createMediumRoomDTO();
        RoomDTO smallRoom = RoomFactory.createSmallRoomDTO();

        HouseDTO house = new HouseDTO();
        house.setRooms(List.of(bigRoom, smallRoom, mediumRoom));

        Integer expectedSquareFeet = 115000;
        Integer expectedBiggestFeet = 80000;
        Integer expectedPrice = expectedSquareFeet * 800;

        mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet", is(expectedSquareFeet)))
                .andExpect(jsonPath("$.biggest.squareFeet", is(expectedBiggestFeet)))
                .andExpect(jsonPath("$.price", is(expectedPrice)));
    }
}
