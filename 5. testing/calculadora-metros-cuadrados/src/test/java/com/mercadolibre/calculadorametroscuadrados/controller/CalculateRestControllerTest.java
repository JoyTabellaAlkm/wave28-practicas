package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
    private static final HouseDTO houseDTO = new HouseDTO();

    static {

        RoomDTO r1 = new RoomDTO();
        r1.setLength(10);
        r1.setWidth(10);

        RoomDTO r2 = new RoomDTO();
        r2.setLength(15);
        r2.setWidth(18);

        houseResponseDTO.setName("Departamento");
        houseResponseDTO.setAddress("Av. Cabildo 2100");
        houseResponseDTO.setRooms(List.of(r1, r2));
        houseResponseDTO.setPrice(296000);
        houseResponseDTO.setSquareFeet(370);
        houseResponseDTO.setBiggest(r2);

        houseDTO.setName("Departamento");
        houseDTO.setAddress("Av. Cabildo 2100");
        houseDTO.setRooms(List.of(r1, r2));

    }


    @Test
    void testCalculatePrice() throws Exception {

        // ARRANGE
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(houseResponseDTO));
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");

        String payloadJSON = objectMapper.writeValueAsString(houseDTO);

        // ACT & ASSERT
        mockMvc.perform(post("/calculate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJSON))
                .andDo(print())
                .andExpect(expectedBody)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType);

    }
}