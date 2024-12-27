package com.mercadolibre.calculadorametroscuadrados.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.web.servlet.*;
import com.fasterxml.jackson.databind.*;
import org.junit.jupiter.api.*;
import com.mercadolibre.calculadorametroscuadrados.dto.*;
import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper= new ObjectMapper();

    @Test
    @DisplayName("01 - Cargar una nueva casa")
    void calculate() throws Exception {
        //arrange
        HouseDTO house= crearCasa();

        ResultMatcher estatusEsperado= status().isOk();
        ResultMatcher contenidoEsperado= content().contentType("application/json");
        ResultMatcher bodyEsperado= content().json(objectMapper.writeValueAsString(house));

        //act assert
        mockMvc.perform(
                        post("/calculate")  // Usamos POST ya que es un RequestBody
                                .contentType("application/json") // Especificamos que es JSON
                                .content(objectMapper.writeValueAsString(house)))
                .andExpect(estatusEsperado)
                .andExpect(contenidoEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());


    }

    private HouseDTO crearCasa() {
        RoomDTO room1 = new RoomDTO("Cocina", 5, 4);  // 20
        RoomDTO room2 = new RoomDTO("Baño", 3, 3);    // 9
        RoomDTO room3 = new RoomDTO("Dormitorio", 6, 5); // 30
        List<RoomDTO> roomList = List.of(room1, room2, room3);

        HouseDTO house = new HouseDTO();
        house.setName("Casa 1");
        house.setRooms(roomList);
        house.setAddress("Av. Siempre Viva 234");

        return house;
    }
}