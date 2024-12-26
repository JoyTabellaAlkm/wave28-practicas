package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final List<CharacterDTO> filteredList;

    static {
        filteredList= new ArrayList<>();
        CharacterDTO c1 = new CharacterDTO();
        c1.setName("Darth Vader");
        c1.setHeight(202);
        c1.setMass(136);
        c1.setHair_color("none");
        c1.setSkin_color("white");
        c1.setEye_color("yellow");
        c1.setBirth_year("41.9BBY");
        c1.setGender("male");
        c1.setHomeworld("Tatooine");
        c1.setSpecies("Human");

        CharacterDTO c2 = new CharacterDTO();
        c2.setName("Darth Maul");
        c2.setHeight(175);
        c2.setMass(80);
        c2.setHair_color("none");
        c2.setSkin_color("red");
        c2.setEye_color("yellow");
        c2.setBirth_year("54BBY");
        c2.setGender("male");
        c2.setHomeworld("Dathomir");
        c2.setSpecies("Zabrak");

        filteredList.add(c1);
        filteredList.add(c2);
    }


    @Test
    void testFindCharacter() throws Exception {

        // ARRANGE
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(filteredList));
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType("application/json");

        // ACT & ASSERT
        mockMvc.perform(get("/{query}", "Darth"))
                .andDo(print())
                .andExpect(expectedBody)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType);

    }


}