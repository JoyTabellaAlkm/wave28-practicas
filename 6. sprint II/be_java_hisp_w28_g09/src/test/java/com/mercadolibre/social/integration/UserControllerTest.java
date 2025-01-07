package com.mercadolibre.social.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.social.dto.response.*;
import com.mercadolibre.social.repository.impl.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.io.IOException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void resetRepository() throws IOException {
        userRepository.resetRepository();
    }

    @Test
    @Order(1)
    @DisplayName("IT-01: Validar acción de “Follow” (seguir) a un determinado usuario")
    public void givenUser_whenFollowAnotherUser_thenUserIsFollowed() throws Exception {
        // ARRANGE

        // Parámetro del seguidor
        Integer followerParam = 1;
        // Parámetro del seguido
        Integer followedParam = 2;
        FollowUserResponseDto response = new FollowUserResponseDto(followerParam, followedParam);
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(response));


        // ACT AND ASSERT
        mockMvc.perform(post("/users/{paramFollower}/follow/{followerParam}", followerParam, followedParam))
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedBody
                ).andDo(print());
    }

    @Test
    @DisplayName("IT-01: Validar acción de “Follow” (seguir) a un usuario que no existe")
    public void givenUser_whenFollowAnotherUser_thenUserNotFound() throws Exception {
        // ARRANGE

        // Parámetro del seguidor
        Integer followerParam = 100;
        // Parámetro del seguido
        Integer followedParam = 2;
        ExceptionDto response = new ExceptionDto("User not found with ID: " + followerParam);
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(response));


        // ACT AND ASSERT
        mockMvc.perform(post("/users/{paramFollower}/follow/{followerParam}", followerParam, followedParam))
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedBody
                ).andDo(print());
    }

    @Test
    @DisplayName("IT-04: Validar listado de todos los vendedores a los cuales sigue un determinado usuario.")
    public void givenUser_whenFetchFollowedSellers_thenReturnSellerList() throws Exception {
        // ARRANGE

        // Parámetro del usuario
        Integer userParam = 2;
        FollowedByUserDto response = new FollowedByUserDto(
                2,
                "alice_smith_test",
                List.of(
                        new UserDto(
                                3,
                                "bob_jones"
                        )
                ));
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(response));


        // ACT AND ASSERT
        mockMvc.perform(get("/users/{userParam}/followed/list", userParam))
                .andExpectAll(
                        expectedStatus,
                        expectedContentType,
                        expectedBody
                ).andDo(print());
    }

    @Test
    @Order(2)
    @DisplayName("IT-05 -> US-02: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor")
    void givenUserId_whenGetCountFollowers_thenReturnCorrectFollowersCount() throws Exception {
        // ARRANGE
        int userId = 3;
        UserCountFollowersDto response = new UserCountFollowersDto(String.valueOf(userId), "bob_jones", 2);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(response));

        // ACT & ASSERT
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpectAll(expectedStatus, expectedContentType, expectedBody)
                .andDo(print());

    }

    @Test
    @Order(3)
    @DisplayName("Carga de JSON según el contexto.")
    public void pruebaTest() throws Exception {
        //ARRANGE
        UserCountFollowersDto bodyEsperadoDTO = new UserCountFollowersDto("1", "john_doe_test", 0);
        Integer parametroEntrada = 1;
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(bodyEsperadoDTO));

        // ACT & ASSERT
        mockMvc.perform(get("/users/{parametroEntrada}/followers/count", parametroEntrada))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());
    }

    @Test
    @Order(4)
    @DisplayName("IT-02 -> US-03: Obtener un listado de todos los usuarios que siguen a un determinado vendedor")
    public void givenUser_whenGetFollowers_thenReturnCorrectFollowersList() throws Exception {
        //ARRANGE
        Integer parametroEntrada = 3;
        FollowersByUserDto bodyEsperadoDTO = new FollowersByUserDto(3, "bob_jones", List.of(new UserDto(1, "john_doe_test"), new UserDto(2, "alice_smith_test")));
        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(objectMapper.writeValueAsString(bodyEsperadoDTO));
        // ACT & ASSERT
        mockMvc.perform(get("/users/{parametroEntrada}/followers/list", parametroEntrada))
                .andExpect(statusEsperado)
                .andExpect(contentTypeEsperado)
                .andExpect(bodyEsperado)
                .andDo(print());

    }

    @Test
    @Order(5)
    @DisplayName("IT-03 -> US-07: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.")
    public void givenUser_whenUnFollow_thenReturnCorrectMessage() throws Exception {
        //ARRANGE
        int userId = 1;
        int userIdToUnfollow = 4;
        MessageDto expected = new MessageDto("User " + userId + " successfully unfollowed User " + userIdToUnfollow);
        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(expected));

        // ACT & ASSERT
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpectAll(statusExpected, contentTypeExpected, bodyExpected)
                .andDo(print());

    }
}