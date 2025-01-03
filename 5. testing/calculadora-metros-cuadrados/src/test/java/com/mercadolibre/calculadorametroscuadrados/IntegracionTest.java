package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegracionTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    HouseDTO houseDTO = new HouseDTO("Casa 1", "calle", new ArrayList<>(List.of(new RoomDTO("habitacion 1", 10, 10))));
    RoomDTO roomDTO = new RoomDTO("habitacion 1", 10, 10);
    HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO,100, 80000,roomDTO);



    @Test
    public void controllerTest() throws Exception{
        HouseResponseDTO esperado = houseResponseDTO;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(esperado)))
                .andExpect(status().isOk());

    }

    @Test
    public void controllerTestBadPath() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate"))
                .andExpect(status().isBadRequest());

    }

}
