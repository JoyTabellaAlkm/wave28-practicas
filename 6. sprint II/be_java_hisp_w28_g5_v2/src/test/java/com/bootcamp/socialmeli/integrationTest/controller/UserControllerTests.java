package com.bootcamp.socialmeli.integrationTest.controller;

import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.request.ProductCreationDto;
import com.bootcamp.socialmeli.dto.request.UserCreationReqDto;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.ProductService;
import com.bootcamp.socialmeli.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @BeforeEach
    void initData() {
        userService.createUsers(List.of(
            new UserCreationReqDto("Tomas"),
            new UserCreationReqDto("Juan"),
            new UserCreationReqDto("Pepe"),
            new UserCreationReqDto("Sara")
        ));
        userService.followUser(1L, 2L);
        userService.followUser(1L, 3L);
        userService.followUser(2L,3L);
        userService.followUser(4L,3L);
    }
    @Test
    void testFollowUser()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",2,1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id",Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[*].user_id",Matchers.hasItem(1)));
    }

    @Test
    void testFollowNonExistentUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",2,100))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(Matchers.is(404)));
    }

    @Test
    void testGetFollowedUsersSuccess() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", Matchers.is(1)))
               .andExpect(MockMvcResultMatchers.jsonPath("$.followed", Matchers.hasSize(2)));
    }

    @Test
    void testGetFollowedUsersFromNonExistentUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 100))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(404)));
    }

    @Test
    void testGetFollowerCount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", Matchers.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count", Matchers.is(3)));
    }

    @Test
    void testGetFollowerCountFromNonExistentUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 100))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(404)));
    }

    @Test
    void testGetFollowersByUserAsc() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",3).param("order","name_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value(Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[2].user_id").value(Matchers.is(1)));
    }
    @Test
    void testGetFollowersByUserDesc() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",3).param("order","name_desc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value(Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[2].user_id").value(Matchers.is(2)));
    }

    @Test
    void testGetFollowersByUserWithInvalidOrder() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",3)
                        .param("order","not_a_valid_order"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(400)));
    }

    @Test
    void testUnfollowUserSuccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name", Matchers.is("Tomas")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[?(@.user_id == 2)]").isEmpty());
    }

    @Test
    void testUnfollowUserFail() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 1))
                .andExpect(MockMvcResultMatchers.status().isForbidden())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("User with id: 2 is not following user with id: 1")));
    }
    @Test
    void testMostFollowedUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/followers/max"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id",Matchers.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count",Matchers.is(3)));
    }
    @Test
    void testGetFollowersByUserSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers", Matchers.isA(List.class)));
    }

    @Test
    void testGetFollowersByUserNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 99))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("User with id: 99 not found")));
    }

    @Test
    void testDeletePostExistentUser() throws Exception{
        ProductCreationDto productDto1 =
                new ProductCreationDto(1L, "Product A", "Type 1", "Brand A", "Red", "Notes A");
        PostCreationDto postDto1 =
                new PostCreationDto(1L, "29-04-2021", productDto1, 1, 2500.2);
        ProductCreationDto productDto2 =
                new ProductCreationDto(2L, "Product B", "Type 2", "Brand B", "Blue", "Notes B");
        PostCreationDto postDto2 =
                new PostCreationDto(1L, "29-04-2021", productDto2, 1, 2500.2);

        productService.createPost(postDto1);
        productService.createPost(postDto2);


        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{user_Id}/posts",1L))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testDeletePostNoExistentUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{user_Id}/posts",100L))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("User with id: 100 not found")));
    }

    @Test
    void createMultipleUsers() throws Exception {
        UserCreationReqDto user1 = new UserCreationReqDto("Fran");
        UserCreationReqDto user2 = new UserCreationReqDto("Esteban");
        mockMvc.perform(MockMvcRequestBuilders.post("/users/createMultiple")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(List.of(user1, user2))))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(2)));
    }

}
