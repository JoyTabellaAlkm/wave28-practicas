package com.bootcamp.socialmeli.integration.controller;

import com.bootcamp.socialmeli.dto.ErrorDto;
import com.bootcamp.socialmeli.dto.request.PostDto;
import com.bootcamp.socialmeli.dto.response.PromoPostsDto;
import com.bootcamp.socialmeli.dto.response.ResponseMessageDto;
import com.bootcamp.socialmeli.utils.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static com.bootcamp.socialmeli.factory.PostDtoFactory.*;
import static com.bootcamp.socialmeli.factory.PostDtoFactory.newPostDtoWithoutPromoWithProductExists;
import static com.bootcamp.socialmeli.utils.TestConstants.*;
import static com.bootcamp.socialmeli.utils.TestUtil.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    public void tearDown() throws Exception {
        TestUtil.createBackup("users.json", "users_backup.json");
        TestUtil.createBackup("posts.json", "posts_backup.json");
    }

    @Test
    public void givenAPostWithoutPromo_whenIsValid_thenReturnSuccessCreatedPost() throws Exception {
        //ARRANGE
        PostDto newPostJson = newPostDtoWithoutPromoValid();

        ResponseMessageDto messageExpected = new ResponseMessageDto("Post creado con éxito!");

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newPostJson));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_OK,
                messageExpected);
    }

    @Test
    public void givenAPostWithoutPromo_whenTheProductExists_thenReturnExceptionProductExists() throws Exception {
        //ARRANGE
        PostDto newPostJson = newPostDtoWithoutPromoWithProductExists();
        ResponseMessageDto messageExpected = new ResponseMessageDto("El producto ya existe");

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newPostJson));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_BAD_REQUEST,
                messageExpected);
    }

    @Test
    public void givenAPostWithoutPromo_whenTheUserDoesNotExist_thenReturnExceptionNonexistentUser() throws Exception {
        //ARRANGE
        PostDto newPostJson = newPostDtoWithoutPromoWithNonexistentUser();
        ResponseMessageDto messageExpected = new ResponseMessageDto("Usuario inexistente");

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newPostJson));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_BAD_REQUEST,
                messageExpected);
    }

    @Test
    public void givenAPostWithoutPromo_whenTheCategoryDoesNotExist_thenReturnExceptionInvalidCategory() throws Exception {
        //ARRANGE
        PostDto newPostJson = newPostDtoWithoutPromoWithInvalidCategory();
        ResponseMessageDto messageExpected = new ResponseMessageDto("Categoria inexistente");

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newPostJson));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_BAD_REQUEST,
                messageExpected);
    }


    @Test
    public void givenAPostWithoutPromo_whenThePriceIsInvalid_thenReturnExceptionIncorrectFormat() throws Exception {
        //ARRANGE
        PostDto newPostJson = newPostDtoWithoutPromoWithInvalidPrice();
        ResponseMessageDto messageExpected = new ResponseMessageDto("Formato incorrecto");

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newPostJson));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_BAD_REQUEST,
                messageExpected);
    }

    @Test
    public void givenAPostWithPromo_whenIsValid_thenReturnSuccessCreatedPost() throws Exception {
        //ARRANGE
        PostDto newPostJson = newPostDtoWithPromoValid();
        ResponseMessageDto messageExpected = new ResponseMessageDto("Post creado con éxito!");

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newPostJson));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_OK,
                messageExpected);
    }

    @Test
    public void givenUserId_whenFollowedUserHaveRecentPost_thenReturnRecentPostsList() throws Exception {
        //ARRANGE
        int userId = 6;
        int lengthExpected = 1;

        MockHttpServletRequestBuilder request = TestUtil.createGetRequest("/products/followed/{userId}/list",
                userId);

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_OK,
                jsonPath("$.posts.length()").value(lengthExpected));

    }

    @Test
    public void givenUserId_whenUserHavePromoPost_thenReturnOnePromo() throws Exception {
        int userId = 1;
        PromoPostsDto promoPostsDtoExpected = new PromoPostsDto(1,
                "Alice",
                1);

        MockHttpServletRequestBuilder request = TestUtil.createGetRequest("/products/promo-post/count")
                .param("user_id", String.valueOf(userId));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_OK,
                promoPostsDtoExpected);
    }


    @Test
    public void givenUserId_whenUserDontHavePromoPost_thenReturnZeroPromo() throws Exception {
        //ARRANGE
        int userId = 4;

        PromoPostsDto promoPostsDtoExpected = new PromoPostsDto(4,
                "Diana",
                0);

        MockHttpServletRequestBuilder request = TestUtil.createGetRequest("/products/promo-post/count")
                .param("user_id", String.valueOf(userId));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_OK,
                promoPostsDtoExpected);
    }

    @Test
    public void givenUserId_whenUserIdDoesNotExist_thenReturnException() throws Exception {
        //ARRANGE
        MockHttpServletRequestBuilder request = TestUtil.createGetRequest("/products/promo-post/count")
                .param("user_id", String.valueOf(USER_ID_NOT_EXIST));

        //ACT & ASSERT
        assertResponse(mockMvc,
                request,
                STATUS_NOT_FOUND,
                jsonResponse(exceptionResponse("No existe un usuario con ID " + USER_ID_NOT_EXIST)));
    }

    @Test
    public void givenInvalidPostData_whenValidationFails_thenReturnsErrorDetails() throws Exception {
        //ARRANGE
        PostDto newPostJson = newPostDtoWithoutPromoWithInvalidEntry();
        ErrorDto errorDto = newErrorDtoInvalidEntry();

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newPostJson));

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                request,
                STATUS_BAD_REQUEST,
                errorDto);

    }

    @Test
    public void givenInvalidPostData_whenIncorrectFormat_thenReturnsErrorInvalidInput() throws Exception {
        //ARRANGE
        String newPostJson = newPostInvalidInput();
        int numberExpectedErrors = 1;
        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPostJson);

        //ACT & ASSERT

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(STATUS_BAD_REQUEST)
                .andExpect(jsonPath("$.errors", hasSize(numberExpectedErrors)))
                .andExpect(jsonPath("$.errors[?(@.name == 'Invalid input')].description")
                        .value("Text 's' could not be parsed at index 0"));
    }
}
