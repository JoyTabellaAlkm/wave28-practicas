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
    public void getFollowerCountOk() throws Exception {
        //ARRANGE
        Integer userId = 3;
        GetFollowerCountDto responseExpected = new GetFollowerCountDto(3,"María López",3);

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(responseExpected));

        //ACT && ASSERT
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpectAll(
                        statusExpected,contentTypeExpected,bodyExpected
                ).andDo(print());
    }

    @Test
    public void getFollowerCountException() throws Exception {
        //ARRANGE
        Integer userId = 60;
        ExceptionDto responseExpected = new ExceptionDto("Usuario no encontrado");

        ResultMatcher statusExpected= status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(responseExpected));

        //ACT && ASSERT
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    //endregion

    //region UNFOLLOW USER
    @Test
    public void unfollowUserOk() throws Exception {

        //ARRANGE
        Integer userId = 6;
        Integer userIdToUnfollow = 2;

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("El usuario se dejo de seguir exitosamente")));

        //ACT && ASSERT
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());

    }

    @Test
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
    public void favouritePostOk() throws Exception {
        //ARRANGE
        String jsonRequest = objectMapper.writer().writeValueAsString(new FavouritePostRequestDto(1,5));

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("Publicación agregada a favoritos exitosamente")));

        //ACT && ASSERT
        mockMvc.perform(post("/users/favourites").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );

    }

    @Test
    public void favouritePostConflictException() throws Exception {
        //ARRANGE
        String jsonRequest = objectMapper.writer().writeValueAsString(new FavouritePostRequestDto(1,2));

        ResultMatcher statusExpected= status().isConflict();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("El post ya está en favoritos")));

        //ACT && ASSERT
        mockMvc.perform(post("/users/favourites").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );
    }

    //endregion

    //region UNFAVOURITE POST

    @Test
    public void unfavouritePostOk() throws Exception {
        //ARRANGE
        String jsonRequest = objectMapper.writer().writeValueAsString(new FavouritePostRequestDto(4,2));

        ResultMatcher statusExpected= status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("Post sacado de favoritos correctamente")));

        //ACT && ASSERT
        mockMvc.perform(post("/users/unfavourite").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );

    }

    @Test
    public void unfavouritePostNotFoundException() throws Exception {
        //ARRANGE
        String jsonRequest = objectMapper.writer().writeValueAsString(new FavouritePostRequestDto(4,232));

        ResultMatcher statusExpected= status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("No se encontro el post")));

        //ACT && ASSERT
        mockMvc.perform(post("/users/unfavourite").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        );

    }

    //endregion

    //region GET FAVOURITE POST

    @Test
    public void favouritePostListOk() throws Exception {
        //ARRANGE
        Integer userId = 1;

        GetFavouritePostsResponseDto responseExpected = MockFactoryUtils.createGetFavouritePostsResponseDtoForUser(userId);

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(responseExpected));

        //ACT & ASSERT
        mockMvc.perform(get("/users/{userId}/favourites", userId)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        ).andDo(print());
    }

    @Test
    public void favouritePostListNotFoundException() throws Exception {
        //ARRANGE
        Integer userId = 222;

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("No se encontró ningún usuario con ese ID.")));

        //ACT & ASSERT
        mockMvc.perform(get("/users/{userId}/favourites", userId)).andExpectAll(
                statusExpected, contentTypeExpected, bodyExpected
        ).andDo(print());
    }

    //endregion

    //region FOLLOW USER
    @Test
    @DisplayName("Seguir usuario exitosamente")
    public void followUserOk() throws Exception {
        // ARRANGE
        Integer userId = 2;
        Integer userIdToFollow = 3;

        ResultMatcher statusExpected = status().isOk();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("El usuario se comenzo a seguir exitosamente")));

        // ACT && ASSERT
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpectAll(
                        statusExpected,
                        contentTypeExpected,
                        bodyExpected
                ).andDo(print());
    }

    @Test
    @DisplayName("Seguir usuario inexistente")
    public void followUserNotFoundException() throws Exception {
        // ARRANGE
        Integer userId = 2;
        Integer userIdToFollow = 3000;

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(new MessageDto("Usuario o vendedor no encontrado")));

        // ACT && ASSERT
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
    public void getFollowedsOrderedByNameInvalidOrderBadRequestException() throws Exception{
        //Arrange
        Integer userId = 1;
        String order = "name";
        ExceptionDto exceptionDto = new ExceptionDto("No es un ordenamiento válido.");

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        //Act + Assert
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    public void getFollowedsOrderedByNameNotOrderList() throws Exception{
        //Arrange
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

        //Act + Assert
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }
    //endregion

    //region FOLLOWERS
    @Test
    public void getFollowersOrderedByNameInvalidOrderBadRequestException() throws Exception{
        //Arrange
        Integer userId = 3;
        String order = "name";
        ExceptionDto exceptionDto = new ExceptionDto("No es un ordenamiento válido.");

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        //Act + Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    public void getFollowersOrderedByNameNotOrderList() throws Exception{
        //Arrange
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

        //Act + Assert
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
    public void getFollowedsOrderedByNameOk() throws Exception{
        //Arrange
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

        //Act + Assert
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    public void getFollowedsOrderedByNameInvalidUserIdNotFoundException() throws Exception{
        //Arrange
        Integer userId = 1000;
        String order = "name_asc";
        ExceptionDto exceptionDto = new ExceptionDto("No se encontró el usuario.");

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        //Act + Assert
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }
    //endregion

    //region FOLLOWERS
    @Test
    public void getFollowersOrderedByNameOk() throws Exception{
        //Arrange
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

        //Act + Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    public void getFollowersOrderedByNameInvalidUserIdNotFoundException() throws Exception{
        //Arrange
        Integer userId = 1000;
        String order = "name_desc";
        ExceptionDto exceptionDto = new ExceptionDto("No se encontró el usuario.");

        ResultMatcher statusExpected = status().isNotFound();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        //Act + Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }

    @Test
    public void getFollowersOrderedByNameISNotSellerBadRequestException() throws Exception{
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        ExceptionDto exceptionDto = new ExceptionDto("El usuario no es un vendedor y no puede tener seguidores.");

        ResultMatcher statusExpected = status().isBadRequest();
        ResultMatcher contentTypeExpected = content().contentType("application/json");
        ResultMatcher bodyExpected = content().json(objectMapper.writeValueAsString(exceptionDto));

        //Act + Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpectAll(
                        statusExpected, contentTypeExpected, bodyExpected
                ).andDo(print());
    }
    //endregion
    //endregion
}
