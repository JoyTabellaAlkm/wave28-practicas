package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraMetrosCuadradosApplicationTests {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  // a) Se pide, retornar un objeto que diga la cantidad totales de metros cuadrados de la casa.
  @Test
  void calculateHouse() throws Exception {
    HouseDTO pepeHouseDTO = getPepeHouseDTO();
    String request1 = objectMapper.writer().writeValueAsString(pepeHouseDTO);
    this.mockMvc.perform(post("/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request1))
            .andDo(print())
            .andExpect(jsonPath("$.squareFeet").value(86))
            .andExpect(jsonPath("$.price").value(68800))
            .andExpect(jsonPath("$.biggest.name").value("Cuarto 2"));
  }

  private String getRoom(String name, int width, int length) {
    return "{\"name\": \""+name+"\", \"width\": "+width+", \"length\": "+length+"}";
  }

  private RoomDTO getRoomDTO(String name, int length, int width) {
    return new RoomDTO(name, length, width);
  }

  private HouseDTO getPepeHouseDTO() {
    HouseDTO houseDTO = new HouseDTO("Casa de Pepe", "Av. Pepon 123", new ArrayList<>());
    houseDTO.getRooms().add(getRoomDTO("Cuarto 1", 5, 5));
    houseDTO.getRooms().add(getRoomDTO("Cuarto 2", 8, 5));
    houseDTO.getRooms().add(getRoomDTO("Cocina", 3, 4));
    houseDTO.getRooms().add(getRoomDTO("Baño", 3, 3));
    return houseDTO;
  }

}
