package com.bootcamp.socialmeli.integrationTest.controller;

import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.request.ProductCreationDto;
import com.bootcamp.socialmeli.dto.request.UserCreationReqDto;
import com.bootcamp.socialmeli.service.PostService;
import com.bootcamp.socialmeli.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PostControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp(){
        userService.createUsers(List.of(
                new UserCreationReqDto("Tomas")
        ));
        ProductCreationDto product1 = new ProductCreationDto(1L, "Product A", "Type 1", "Brand A", "Red", "Notes A");
        ProductCreationDto product2 = new ProductCreationDto(2L, "Product B", "Type 2", "Brand B", "Blue", "Notes B");
        ProductCreationDto product3 = new ProductCreationDto(3L, "Product C", "Type 3", "Brand C", "Cyan", "Notes C");
        postService.createPosts(List.of(
                        new PostCreationDto(1L, "31-12-2024", product1, 1, 100.0),
                        new PostCreationDto(1L, "31-12-2024", product2, 2, 150.0),
                        new PostCreationDto(1L, "31-12-2024", product3, 1, 150.0)
        ));
    }
    @Test
    void getPosts() throws Exception {
        mvc.perform((MockMvcRequestBuilders.get("/posts").param("category","1")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].category", Matchers.everyItem(Matchers.is(1))));
    }

    @Test
    void createMultiplePosts() throws Exception {
        ProductCreationDto product1 =
                new ProductCreationDto(100L, "Product X", "Type 1", "Brand A", "Red", "Notes A");
        PostCreationDto post1 =
                new PostCreationDto(1L, "31-12-2024", product1, 1, 100.0);
        ProductCreationDto product2 = new ProductCreationDto(101L, "Product Y", "Type 2", "Brand B", "Blue", "Notes B");
        PostCreationDto post2 =
                new PostCreationDto(1L, "31-12-2024", product2, 2, 150.0);

        mvc.perform((MockMvcRequestBuilders.post("/posts/createMultiple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(List.of(post1, post2)))))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(2)));
    }
}