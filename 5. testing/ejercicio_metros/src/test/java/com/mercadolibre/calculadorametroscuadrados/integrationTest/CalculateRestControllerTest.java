package com.mercadolibre.calculadorametroscuadrados.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    private static HouseDTO houseDTO;

    @BeforeAll
    public static void init() {
        objectMapper = new ObjectMapper();
        RoomDTO salaDeEstar = new RoomDTO(
                "Sala de Estar",
                5,
                7
        );
        RoomDTO dormitorio = new RoomDTO(
                "Dormitorio",
                4,
                4
        );
        RoomDTO cocina = new RoomDTO(
                "Cocina",
                4,
                6
        );
        List<RoomDTO> hambientes = List.of(
                salaDeEstar, cocina, dormitorio
        );
        houseDTO = new HouseDTO(
                "Casa de Verano",
                "Calle Ficticia 123",
                hambientes
        );
    }

    @Test
    public void testRegisterStudent() throws Exception {
        mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(houseDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Casa de Verano"))
                .andExpect(jsonPath("$.address").value("Calle Ficticia 123"))
                .andExpect(jsonPath("$.squareFeet").value(75))
                .andExpect(jsonPath("$.price").value(60000))
                .andExpect(jsonPath("$.biggest.name").value("Sala de Estar"))
                .andExpect(jsonPath("$.biggest.width").value(5))
                .andExpect(jsonPath("$.biggest.length").value(7))
                .andExpect(jsonPath("$.biggest.squareFeet").value(35))
                .andExpect(jsonPath("$.rooms[0].name").value("Sala de Estar"))
                .andExpect(jsonPath("$.rooms[0].width").value(5))
                .andExpect(jsonPath("$.rooms[0].length").value(7))
                .andExpect(jsonPath("$.rooms[0].squareFeet").value(35))
                .andExpect(jsonPath("$.rooms[1].name").value("Cocina"))
                .andExpect(jsonPath("$.rooms[1].width").value(4))
                .andExpect(jsonPath("$.rooms[1].length").value(6))
                .andExpect(jsonPath("$.rooms[1].squareFeet").value(24))
                .andExpect(jsonPath("$.rooms[2].name").value("Dormitorio"))
                .andExpect(jsonPath("$.rooms[2].width").value(4))
                .andExpect(jsonPath("$.rooms[2].length").value(4))
                .andExpect(jsonPath("$.rooms[2].squareFeet").value(16));
    }

}
