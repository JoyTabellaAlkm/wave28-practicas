package com.bootcamp.social_meli.integration.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindFollowedListEndpointIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFindFollowerListSuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/4/followed/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("CarlosSan_15"))
                .andExpect(jsonPath("$.followed.length()").value(3))
                .andExpect(jsonPath("$.followed[0].user_id").value(2))
                .andExpect(jsonPath("$.followed[0].user_name").value("MartinG23"))
                .andExpect(jsonPath("$.followed[1].user_id").value(3))
                .andExpect(jsonPath("$.followed[1].user_name").value("AnaPerezzz"))
                .andExpect(jsonPath("$.followed[2].user_id").value(5))
                .andExpect(jsonPath("$.followed[2].user_name").value("LauLopez87"));
    }

    @Test
    public void testFindFollowerListNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/99/followed/list"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("404"))
                .andExpect(jsonPath("$.message").value("No se ha encontrado al usuario: 99"));
    }

    @Test
    public void testFindFollowerListInvalidUserId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/-1/followed/list"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("userId debe ser mayor que o igual a 1"));
    }

    @Test
    public void testFindFollowerListInvalidOrderParameter() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/4/followed/list?order=asc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("El parámetro 'order' no es válido. Los " +
                        "valores aceptables son 'name_asc' o 'name_desc'."));
    }

    @Test
    public void testFindFollowerListWithOrderParameterAsc() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/4/followed/list?order=name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("CarlosSan_15"))
                .andExpect(jsonPath("$.followed.length()").value(3))
                .andExpect(jsonPath("$.followed[0].user_id").value(3))
                .andExpect(jsonPath("$.followed[0].user_name").value("AnaPerezzz"))
                .andExpect(jsonPath("$.followed[1].user_id").value(5))
                .andExpect(jsonPath("$.followed[1].user_name").value("LauLopez87"))
                .andExpect(jsonPath("$.followed[2].user_id").value(2))
                .andExpect(jsonPath("$.followed[2].user_name").value("MartinG23"));
    }
    @Test
    public void testFindFollowerListWithOrderParameterDesc() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/4/followed/list?order=name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("CarlosSan_15"))
                .andExpect(jsonPath("$.followed.length()").value(3))
                .andExpect(jsonPath("$.followed[0].user_id").value(2))
                .andExpect(jsonPath("$.followed[0].user_name").value("MartinG23"))
                .andExpect(jsonPath("$.followed[1].user_id").value(5))
                .andExpect(jsonPath("$.followed[1].user_name").value("LauLopez87"))
                .andExpect(jsonPath("$.followed[2].user_id").value(3))
                .andExpect(jsonPath("$.followed[2].user_name").value("AnaPerezzz"));
    }

}
