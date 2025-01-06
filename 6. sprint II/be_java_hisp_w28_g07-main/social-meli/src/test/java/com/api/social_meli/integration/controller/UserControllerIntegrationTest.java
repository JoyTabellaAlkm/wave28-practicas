package com.api.social_meli.integration.controller;

import com.api.social_meli.dto.*;
import com.api.social_meli.util.MockFactoryUtils;
import com.api.social_meli.dto.ExceptionDto;
import com.api.social_meli.dto.FavouritePostRequestDto;
import com.api.social_meli.dto.GetFollowerCountDto;
import com.api.social_meli.dto.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectMapper objectMapper;

    @BeforeAll
    public static void setUp() {
        objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
    }

    //region GET FOLLOWER COUNT

    @Test
    @DisplayName("T-0002 - Obtiene la cantidad de Followers de un usuario. Ok.")
    public void getFollowerCountOk() throws Exception {
        // Arrange
        Integer userId = 3;
        GetFollowerCountDto responseExpected = new GetFollowerCountDto(3,"María López",3);

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(responseExpected));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpectAll(
                        statusExpected,contentTypeExpected,bodyExpected
                ).andDo(print());
    }

    @Test
    @DisplayName("T-0002 - Obtener la cantidad de Followers de un usuario. NotFound.")
    public void getFollowerCountNotFoundException() throws Exception {
        // Arrange
        Integer userId = 60;
        ExceptionDto responseExpected = new ExceptionDto("Usuario no encontrado");

        ResultMatcher statusExpected= status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(responseExpected));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    //endregion

    //region UNFOLLOW USER

    @Test
    @DisplayName("T-0002 - Deja de seguir a un usuario. Ok.")
    public void unfollowUserOk() throws Exception {

        // Arrange
        Integer userId = 6;
        Integer userIdToUnfollow = 2;

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("El usuario se dejo de seguir exitosamente")));

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());

    }

    @Test
    @DisplayName("T0002 - Deja de seguir a un usuario. BadRequest.")
    public void unfollowUserBadRequestException() throws Exception {
        Integer userId = 2;
        Integer userIdToUnfollow = 5;

        ResultMatcher statusExpected= status().isBadRequest();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("Actualmente no sigue a ese usuario")));

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    //endregion

    //region FAVOURITE POST

    @Test
    @DirtiesContext
    @DisplayName("Bonus - Agrega un Post a favoritos. Ok.")
    public void favouritePostOk() throws Exception {
        // Arrange
        String jsonRequest = objectMapper.writer().writeValueAsString(new FavouritePostRequestDto(1,5));

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("Publicación agregada a favoritos exitosamente")));

        // Act & Assert
        mockMvc.perform(post("/users/favourites").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );

    }

    @Test
    @DisplayName("Bonus - Agregar un Post a favoritos. Conflict.")
    public void favouritePostConflictException() throws Exception {
        // Arrange
        String jsonRequest = objectMapper.writer().writeValueAsString(new FavouritePostRequestDto(1,2));

        ResultMatcher statusExpected= status().isConflict();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("El post ya está en favoritos")));

        // Act & Assert
        mockMvc.perform(post("/users/favourites").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );
    }

    //endregion

    //region UNFAVOURITE POST

    @Test
    @DisplayName("Bonus - Saca un Post de favoritos. Ok.")
    public void unfavouritePostOk() throws Exception {
        // Arrange
        String jsonRequest = objectMapper.writer().writeValueAsString(new FavouritePostRequestDto(4,2));

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("Post sacado de favoritos correctamente")));

        // Act & Assert
        mockMvc.perform(post("/users/unfavourite").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );

    }

    @Test
    @DisplayName("Bonus - Saca un Post de favoritos. NotFound.")
    public void unfavouritePostNotFoundException() throws Exception {
        // Arrange
        String jsonRequest = objectMapper.writer().writeValueAsString(new FavouritePostRequestDto(4,232));

        ResultMatcher statusExpected= status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("No se encontro el post")));

        // Act & Assert
        mockMvc.perform(post("/users/unfavourite").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );

    }

    //endregion

    //region GET FAVOURITE POST

    @Test
    @DisplayName("Bonus - Obtiene la lista de favoritos de un usuario. Ok.")
    public void favouritePostListOk() throws Exception {
        // Arrange
        Integer userId = 1;

        GetFavouritePostsResponseDto responseExpected = MockFactoryUtils.createGetFavouritePostsResponseDtoForUser();

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(responseExpected));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/favourites", userId)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        ).andDo(print());
    }

    @Test
    @DisplayName("Bonus - Obtener lista de Favoritos de un usuario. NotFound.")
    public void favouritePostListNotFoundException() throws Exception {
        // Arrange
        Integer userId = 222;

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("No se encontró ningún usuario con ese ID.")));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/favourites", userId)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        ).andDo(print());
    }

    //endregion

    //region FOLLOW USER

    @Test
    @DisplayName("T-0001 - Seguir usuario exitosamente. Ok.")
    public void followUserOk() throws Exception {
        // Arrange
        Integer userId = 2;
        Integer userIdToFollow = 3;

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("El usuario se comenzo a seguir exitosamente")));

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpectAll(
                        statusExpected,
                        contentTypeExpected,
                        bodyExpected
                ).andDo(print());
    }

    @Test
    @DisplayName("T-0001 - Seguir usuario inexistente. NotFound.")
    public void followUserNotFoundException() throws Exception {
        // Arrange
        Integer userId = 2;
        Integer userIdToFollow = 3000;

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("Usuario o vendedor no encontrado")));

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpectAll(
                        statusExpected,
                        contentTypeExpected,
                        bodyExpected
                ).andDo(print());
    }

    //endregion

    //region GET FOLLOWS LISTS

    //region FOLLOWEDS

    @Test
    @DisplayName("T-0003 - Obtener Followeds de un usuario. BadRequest.")
    public void getFollowedsOrderedByNameInvalidOrderBadRequestException() throws Exception{
        // Arrange
        Integer userId = 1;
        String order = "name";
        ExceptionDto exceptionDto = new ExceptionDto("No es un ordenamiento válido.");

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    @DisplayName("T-0003 - Obtener Followeds de un usuario. Ok.")
    public void getFollowedsOrderedByNameNotOrderList() throws Exception{
        // Arrange
        Integer userId = 1;
        String order = null;
        FollowedListDto listSpected = new FollowedListDto(
                1,
                "Ana Martínez",
                new ArrayList<>(
                        List.of(
                                new FollowDto(3, "María López"),
                                new FollowDto(4, "Juan Pérez"),
                                new FollowDto(5, "Lucía Fernández")
                        )
                )
        );

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(listSpected));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }
    //endregion

    //region FOLLOWERS
    @Test
    @DisplayName("T-0003 - Obtener Followers de un usuario. BadRequest.")
    public void getFollowersOrderedByNameInvalidOrderBadRequestException() throws Exception{
        // Arrange
        Integer userId = 3;
        String order = "name";
        ExceptionDto exceptionDto = new ExceptionDto("No es un ordenamiento válido.");

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    @DisplayName("T-0003 - Obtener Followers de un usuario. Ok.")
    public void getFollowersOrderedByNameNotOrderList() throws Exception{
        // Arrange
        Integer userId = 3;
        String order = null;
        FollowerListDto listSpected = new FollowerListDto(
                3,
                "María López",
                new ArrayList<>(
                        List.of(
                                new FollowDto(1, "Ana Martínez"),
                                new FollowDto(5, "Lucía Fernández"),
                                new FollowDto(6, "Miguel Rodríguez")
                        )
                )
        );

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(listSpected));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    //endregion

    //endregion

    //region GET FOLLOWS SORTED LISTS

    //region FOLLOWEDS

    @Test
    @DisplayName("T-0003 - Obtener Followeds de un usuario. Ok.")
    public void getFollowedsOrderedByNameOk() throws Exception{
        // Arrange
        Integer userId = 1;
        String order = "name_asc";
        FollowedListDto listSpected = new FollowedListDto(
                1,
                "Ana Martínez",
                new ArrayList<>(
                        List.of(
                                new FollowDto(4, "Juan Pérez"),
                                new FollowDto(5, "Lucía Fernández"),
                                new FollowDto(3, "María López")
                        )
                )
        );

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(listSpected));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    @DisplayName("T-0004 - Obtener Followeds de un usuario. NotFound.")
    public void getFollowedsOrderedByNameInvalidUserIdNotFoundException() throws Exception{
        // Arrange
        Integer userId = 1000;
        String order = "name_asc";
        ExceptionDto exceptionDto = new ExceptionDto("No se encontró el usuario.");

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    //endregion

    //region FOLLOWERS

    @Test
    @DisplayName("T-0004 - Obtener Followers de un usuario. Ok.")
    public void getFollowersOrderedByNameOk() throws Exception{
        // Arrange
        Integer userId = 3;
        String order = "name_desc";
        FollowerListDto listSpected = new FollowerListDto(
                3,
                "María López",
                new ArrayList<>(
                        List.of(
                                new FollowDto(6, "Miguel Rodríguez"),
                                new FollowDto(5, "Lucía Fernández"),
                                new FollowDto(1, "Ana Martínez")
                        )
                )
        );

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(listSpected));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    @DisplayName("T-0004 - Obtener Followers de un usuario. NotFound.")
    public void getFollowersOrderedByNameInvalidUserIdNotFoundException() throws Exception{
        // Arrange
        Integer userId = 1000;
        String order = "name_desc";
        ExceptionDto exceptionDto = new ExceptionDto("No se encontró el usuario.");

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    @DisplayName("T-0004 - Obtener Followers de un usuario que no es vendedor. BadRequest.")
    public void getFollowersOrderedByNameISNotSellerBadRequestException() throws Exception{
        // Arrange
        Integer userId = 1;
        String order = "name_desc";
        ExceptionDto exceptionDto = new ExceptionDto("El usuario no es un vendedor y no puede tener seguidores.");

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    //endregion

    //endregion
}
