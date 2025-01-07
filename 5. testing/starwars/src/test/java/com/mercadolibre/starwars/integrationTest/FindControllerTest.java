package com.mercadolibre.starwars.integrationTest;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.ResourceUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {
    @Autowired
    MockMvc mockMvc;

    String query = "DarTh";
    String wrongQuery = "DarThpo";

    @Test
    public void findCharacterFunnyPath() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))

                .andExpect(jsonPath("$[0].name").value("Darth Vader"))
                .andExpect(jsonPath("$[0].hair_color").value("none"))
                .andExpect(jsonPath("$[0].skin_color").value("white"))
                .andExpect(jsonPath("$[0].eye_color").value("yellow"))
                .andExpect(jsonPath("$[0].birth_year").value("41.9BBY"))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].homeworld").value("Tatooine"))
                .andExpect(jsonPath("$[0].species").value("Human"))
                .andExpect(jsonPath("$[0].height").value(202))
                .andExpect(jsonPath("$[0].mass").value(136))

                .andExpect(jsonPath("$[1].name").value("Darth Maul"))
                .andExpect(jsonPath("$[1].hair_color").value("none"))
                .andExpect(jsonPath("$[1].skin_color").value("red"))
                .andExpect(jsonPath("$[1].eye_color").value("yellow"))
                .andExpect(jsonPath("$[1].birth_year").value("54BBY"))
                .andExpect(jsonPath("$[1].gender").value("male"))
                .andExpect(jsonPath("$[1].homeworld").value("Dathomir"))
                .andExpect(jsonPath("$[1].species").value("Zabrak"))
                .andExpect(jsonPath("$[1].height").value(175))
                .andExpect(jsonPath("$[1].mass").value(80));
    }

    @Test
    void testAnalyzeScoresThrowStudentEmptyArray() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", wrongQuery))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

}
