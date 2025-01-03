package com.spring1.meliSocial.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring1.meliSocial.dto.response.*;
import org.junit.jupiter.api.DisplayName;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();

    private static final String USERS_PATH = "/users/";

    private FollowedDto followed1;
    private FollowedDto followed2;
    private FollowerDto follower1;

    @Test
    @DisplayName("Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor")
    public void testGetFollowerCountOK() throws Exception {
        int parametroEntrada = 1;
        UserFollowersDto result = new UserFollowersDto(1, "Agustina Lopez", 4);

        mockMvc.perform(get("/users/{userId}/followers/count", parametroEntrada))
                .andExpectAll(
                        status().isOk(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result))
                )
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener NotFound de la cantidad de usuarios que siguen a un determinado vendedor")
    public void testGetFollowerCountNotFound() throws Exception {
        int parametroEntrada = 10;
        ResponseDto result = new ResponseDto("El id que busca no existe");

        mockMvc.perform(get("/users/{userId}/followers/count", parametroEntrada))
                .andExpectAll(
                        status().isNotFound(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result))
                )
                .andDo(print());
    }

    @Test
    @DisplayName("Poder realizar la acción de “Follow” (seguir) a un determinado vendedor")
    public void testFollowUserOK() throws Exception {
        ResponseDto result = new ResponseDto("Siguiendo al usuario: Agustina Lopez con ID: 1");
        int user = 4;
        int userToFollow = 1;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",user,userToFollow))
                .andExpectAll(
                        status().isOk(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result))
                )
                .andDo(print());
    }

    @Test
    @DisplayName("“Follow” (seguir) a un determinado vendedor NotFound user")
    public void testFollowUserNotFoundUser() throws Exception {
        int user = 40;
        int userToFollow = 1;
        ResponseDto result = new ResponseDto("El usuario con ID: " + user + " no existe.");

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",user,userToFollow))
                .andExpectAll(
                        status().isNotFound(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result))
                )
                .andDo(print());
    }

    @Test
    @DisplayName("“Follow” (seguir) a un determinado vendedor NotFound userToFollow")
    public void testFollowUserNotFoundUserToFollow() throws Exception {
        int user = 4;
        int userToFollow = 100;
        ResponseDto result = new ResponseDto("El usuario a seguir con ID: " + userToFollow + " no existe.");

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",user,userToFollow))
                .andExpectAll(
                        status().isNotFound(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result))
                )
                .andDo(print());
    }

    @Test
    @DisplayName("“Follow” (seguir) a un determinado vendedor con ID iguales")
    public void testFollowUserBadRequestExceptionEqualsID() throws Exception {
        int user = 4;
        int userToFollow = 4;
        ResponseDto result = new ResponseDto("Un usuario no puede seguirse a sí mismo.");

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",user,userToFollow))
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result))
                )
                .andDo(print());
    }

    @Test
    @DisplayName("“Follow” (seguir) a un determinado vendedor - ya contiene ese seguidor")
    public void testFollowUserBadRequestExceptionRepeatFollower() throws Exception {
        int user = 2;
        int userToFollow = 1;
        ResponseDto result = new ResponseDto("El usuario con ID: " + user + " ya sigue al usuario con ID: " + userToFollow);

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",user,userToFollow))
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result))
                )
                .andDo(print());
    }


    @Test
    @DisplayName("“Follow” (seguir) a un determinado vendedor - el usuario a seguir no es vendedor")
    public void testFollowUserBadRequestExceptionNoASeller() throws Exception {
        int user = 2;
        int userToFollow = 3;
        ResponseDto result = new ResponseDto("Un comprador solo puede seguir a un usuario vendedor.");

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",user,userToFollow))
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result))
                )
                .andDo(print());
    }

    @Test
    @DisplayName("“Follow” (seguir) a un determinado vendedor - el usuario a seguir no es vendedor")
    public void testFollowUserBadRequestExceptionNoASeller2() throws Exception {
        int user = 1;
        int userToFollow = 2;
        ResponseDto result = new ResponseDto("Solo se puede seguir a un usuario vendedor.");

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",user,userToFollow))
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result)))
                .andDo(print());
    }


    @Test
    public void testFollowedList() throws Exception {
        followed1 = new FollowedDto(1, "Agustina Lopez");
        followed2 = new FollowedDto(6, "Fausto Smith");

        List<FollowedDto> seguidos = new ArrayList<>(List.of(followed1));
        FollowedByUserDto esperado = new FollowedByUserDto(3, "Carlos Perez", seguidos);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonEsperado = objectMapper.writeValueAsString(esperado);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{studentId}/followed/list", 3))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(jsonEsperado));
    }

    @Test
    public void testFollowedListNotFoundID() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{studentId}/followed/list", 100))
                .andExpect(status().isNotFound());

    }

    @Test
    public void testFollowedListAsc() throws Exception {
        followed1 = new FollowedDto(1, "Agustina Lopez");
        followed2 = new FollowedDto(6, "Fausto Smith");

        List<FollowedDto> seguidos = new ArrayList<>(List.of(followed1, followed2));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonEsperado = objectMapper.writeValueAsString(seguidos);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{studentId}/followed/list", 5))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followed", Matchers.hasSize(seguidos.size())))
                .andExpect(jsonPath("$.followed[0].user_id").value(seguidos.get(0).getId()))
                .andExpect(jsonPath("$.followed[0].user_name").value(seguidos.get(0).getUserName()))
                .andExpect(jsonPath("$.followed[1].user_id").value(seguidos.get(1).getId()))
                .andExpect(jsonPath("$.followed[1].user_name").value(seguidos.get(1).getUserName()));
    }

    @Test
    public void testFollowedListDesc() throws Exception {
        followed1 = new FollowedDto(1, "Agustina Lopez");
        followed2 = new FollowedDto(6, "Fausto Smith");

        List<FollowedDto> seguidos = new ArrayList<>(List.of(followed2, followed1));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonEsperado = objectMapper.writeValueAsString(seguidos);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{studentId}/followed/list", 5).param("order", "name_desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followed", Matchers.hasSize(seguidos.size())))
                .andExpect(jsonPath("$.followed[0].user_id").value(seguidos.get(0).getId()))
                .andExpect(jsonPath("$.followed[0].user_name").value(seguidos.get(0).getUserName()))
                .andExpect(jsonPath("$.followed[1].user_id").value(seguidos.get(1).getId()))
                .andExpect(jsonPath("$.followed[1].user_name").value(seguidos.get(1).getUserName()));
    }

    @Test
    @DisplayName("Obtener listado de seguidores de un usuario con el ordenamiento por default (asc)")
    void testGetFollowersFromSeller_WithDefaultOrder() throws Exception {
        int userId = 6;
        follower1 = new FollowerDto(5, "Esteban Marquez");

        List<FollowerDto> followers = new ArrayList<>(List.of(follower1));
        SellerFollowersDto followersEsperado = new SellerFollowersDto(userId, "Fausto Smith", followers);

        String jsonEsperado = objectMapper.writeValueAsString(followersEsperado);

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(jsonEsperado);

        mockMvc.perform(get(USERS_PATH + "{userId}/followers/list", userId)
                        .param("order", "name_asc"))
                .andExpect(jsonPath("$.followers", Matchers.hasSize(1)))
                .andExpectAll(
                        statusEsperado, contentTypeEsperado, bodyEsperado
                )
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener listado de seguidores de un usuario con el ordenamiento descendente")
    void testGetFollowersFromSeller_WithDescOrder() throws Exception {
        int userId = 1;

        ResultMatcher statusEsperado = status().isOk();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");

        mockMvc.perform(get(USERS_PATH + "{userId}/followers/list", userId)
                        .param("order", "name_desc"))
                .andExpect(jsonPath("$.followers", Matchers.hasSize(4)))
                .andExpectAll(
                        statusEsperado, contentTypeEsperado
                )
                .andExpect(jsonPath("$.followers[0].user_name").value("Fausto Smith"))
                .andExpect(jsonPath("$.followers[3].user_name").value("Bautista Gomez"))
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener NotFound del listado de seguidores de un usuario que no existe")
    void testGetFollowersFromSeller_WithInvalidUser() throws Exception {
        int userIdInvalid = 999;
        String expectedErrorMessage = """
                    {
                        "message": "El id ingresado no se corresponde a un user existente"
                    }
                """;

        ResultMatcher statusEsperado = status().isNotFound();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(expectedErrorMessage);

        mockMvc.perform(get(USERS_PATH + "{userId}/followers/list", userIdInvalid)
                        .param("order", "name_asc"))
                .andExpectAll(
                        statusEsperado, contentTypeEsperado, bodyEsperado
                )
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener BadRequest del listado de seguidores de un usuario que no es vendedor")
    void testGetFollowersFromSeller_WithNonSellerUser() throws Exception {
        int userIdNonSeller = 2;
        String expectedErrorMessage = """
                    {
                        "message": "El usuario ingresado no se trata de un vendedor y por lo tanto no puede tener seguidores"
                    }
                """;

        ResultMatcher statusEsperado = status().isBadRequest();
        ResultMatcher contentTypeEsperado = content().contentType("application/json");
        ResultMatcher bodyEsperado = content().json(expectedErrorMessage);

        mockMvc.perform(get(USERS_PATH + "{userId}/followers/list", userIdNonSeller)
                        .param("order", "name_asc"))
                .andExpectAll(
                        statusEsperado, contentTypeEsperado, bodyEsperado
                )
                .andDo(print());
    }

    @Test
    @DisplayName("DELETE /users/{userId}/favourite-post/{postId} Delete favourite post Ok")
    public void testRemoveFavouritePostOk() throws Exception {
        int userId = 2;
        int postId = 1;

        mockMvc.perform(delete("/users/{userId}/favourite-post/{postId}", userId, postId))
                .andExpectAll(status().isNoContent())
                .andDo(print());
    }

    @Test
    @DisplayName("DELETE /users/{userId}/favourite-post/{postId} Delete favourite post User not found")
    public void testRemoveFavouritePost_User_Not_Found() throws Exception {
        int userId = 123;
        int postId = 1;
        String expectedErrorMessage = """
                    {
                        "message": "El usuario con ID: 123 no existe."
                    }
                """;

        mockMvc.perform(delete("/users/{userId}/favourite-post/{postId}", userId, postId))
                .andExpectAll(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedErrorMessage))
                .andDo(print());
    }

    @Test
    @DisplayName("DELETE /users/{userId}/favourite-post/{postId} Delete favourite Post not found")
    public void testRemoveFavouritePost_Post_Not_Found() throws Exception {
        int userId = 1;
        int postId = 123;
        String expectedErrorMessage = """
                    {
                        "message": "El post con id 123 no está agregado a favoritos para el usuario"
                    }
                """;

        mockMvc.perform(delete("/users/{userId}/favourite-post/{postId}", userId, postId))
                .andExpectAll(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedErrorMessage))
                .andDo(print());
    }

    @Test
    @DisplayName("Obtener el mensaje de que un usuario dejó de seguir a un usuario vendedor")
    public void testUnfollowUser_ok() throws Exception{
        int userId = 9;
        int userIdToUnfollow = 8;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario dejó de seguir a Juan Roman"));
    }

    @Test
    @DisplayName("Obtener notFound cuando un usuario vendedor no existe")
    public void testUnfollowUser_userIdToUnfollowNotFound() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 999;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se encontraron los usuarios"));
    }

    @Test
    @DisplayName("Obtener notFound cuando un usuario no existe")
    public void testUnfollowUser_userIdNotFound() throws Exception {
        int userId = 999;
        int userIdToUnfollow = 8;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se encontraron los usuarios"));
    }

    @Test
    @DisplayName("Obtener notFound cuando un usuario no tiene seguidos")
    public void testUnfollowUser_userIdToUnfollowNotFoundFollower() throws Exception {
        int userId = 4;
        int userIdToUnfollow = 2;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no tiene seguidos"));
    }

    @Test
    @DisplayName("Obtener notFound cuando un usuario no tiene ese seguido")
    public void testUnfollowUser_userIdToUnfollowNotContainFollower() throws Exception {
        int userId = 5;
        int userIdToUnfollow = 2;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no contiene ese seguido"));
    }

    @Test
    @DisplayName("Agrega a favoritos")
    public void testAddFavouritePostOK() throws Exception {
        int user = 1;
        int postId = 1;
        ResponseDto result = new ResponseDto("El post fue agregado a favoritos de forma exitosa");

        mockMvc.perform(post("/users/{userId}/favourite-post/{postId}",user,postId))
                .andExpectAll(
                        status().isOk(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result)))
                .andDo(print());
    }

    @Test
    @DisplayName("Agrega a favoritos - User NotFound")
    public void testAddFavouritePostNotFoundExceptionUser() throws Exception {
        int user = 100;
        int postId = 1;
        ResponseDto result = new ResponseDto("El usuario con ID: " + user + " no existe.");

        mockMvc.perform(post("/users/{userId}/favourite-post/{postId}",user,postId))
                .andExpectAll(
                        status().isNotFound(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result)))
                .andDo(print());
    }

    @Test
    @DisplayName("Agrega a favoritos - Post NotFound")
    public void testAddFavouritePostNotFoundExceptionPost() throws Exception {
        int user = 1;
        int postId = 100;
        ResponseDto result = new ResponseDto("El post con ID: " + postId + " no existe.");

        mockMvc.perform(post("/users/{userId}/favourite-post/{postId}",user,postId))
                .andExpectAll(
                        status().isNotFound(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result)))
                .andDo(print());
    }

    @Test
    @DisplayName("Agrega a favoritos - BadRequestException el post ya esta agregado")
    public void testAddFavouritePostBadRequestException() throws Exception {
        int user = 2;
        int postId = 1;
        ResponseDto result = new ResponseDto("El post con id " + postId + " ya está agregado a favoritos");

        mockMvc.perform(post("/users/{userId}/favourite-post/{postId}",user,postId))
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType("application/json"),
                        content().json(objectMapper.writeValueAsString(result)))
                .andDo(print());
    }

}
