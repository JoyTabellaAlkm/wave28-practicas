package com.mercadolibre.calculadorametroscuadrados;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestController {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Debe calcular los pies cuadrados de una casa")
    public void shouldCalculateSquareFeetForARoom() throws JsonProcessingException, Exception {
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
        expected.setSquareFeet(20 * 20 + 10 * 20);
        expected.setBiggest(room1);
        expected.setPrice(expected.getSquareFeet() * 800);

        ResultMatcher status = status().isOk();
        ResultMatcher contentType = content().contentType("application/json");

        // act
        MvcResult result = mockMvc.perform(
                post("/calculate")
                        .content(objectMapper.writeValueAsString(req))
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status)
                .andExpect(contentType)
                .andExpect(contentType)
                .andReturn();

        // assert
        assertEquals(objectMapper.writeValueAsString(expected), result.getResponse().getContentAsString());
    }

}
