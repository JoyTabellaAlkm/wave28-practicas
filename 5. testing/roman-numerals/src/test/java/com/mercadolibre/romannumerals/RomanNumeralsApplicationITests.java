package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsApplicationITests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void givenNumberTen_whenIsRomanNumber_thenReturnX() throws Exception {
    performTest("1", "I");
  }

  @Test
  void givenNumberOne_whenIsRomanNumber_thenReturnI() throws Exception {
    performTest("10", "X");
  }

  @Test
  void givenNumberMil_whenIsRomanNumber_thenReturnM() throws Exception {
    performTest("1000", "M");
  }

  private void performTest(String decimal, String roman) throws Exception {
    this.mockMvc.perform(get("/" + decimal))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(roman)));
  }
}
