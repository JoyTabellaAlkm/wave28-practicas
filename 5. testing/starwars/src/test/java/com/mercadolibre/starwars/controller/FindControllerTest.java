package com.mercadolibre.starwars.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("Debe encontrar a Luke Skywalker")
  public void findOcurrences() throws Exception {
    // arrange
    String query = "Luke";
    ResultMatcher status = status().isOk();
    ResultMatcher contentType = content().contentType("application/json");
    ResultMatcher jsonPath = jsonPath("$[0].name").value("Luke Skywalker");

    // act & assert
    mockMvc.perform(get("/" + query))
      .andDo(print())
      .andExpect(status)
      .andExpect(contentType)
      .andExpect(jsonPath);
  }

  @Test
  @DisplayName("Debe retornar una lista vacía")
  public void findNoneOcurrences() throws Exception {
    // arrange
    String query = "No existe";
    ResultMatcher status = status().isOk();
    ResultMatcher contentType = content().contentType("application/json");

    // act & assert
    MvcResult result = mockMvc.perform(get("/" + query))
      .andDo(print())
      .andExpect(status)
      .andExpect(contentType)
      .andReturn();

    String content = result.getResponse().getContentAsString();
    assertEquals("[]", content);
  }

}
