package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.dto.response.ExceptionDto;
import com.bootcamp.socialmeli.dto.response.UserFollowedDto;
import com.bootcamp.socialmeli.dto.response.UserIdentificationDto;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.factory.UserFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class TestUtil {

    public static UserFollowedDto createUserFollowedDto(int followerUserId, String followerName, List<User> sellersToFollow) {
        List<UserIdentificationDto> sellerDtos = sellersToFollow.stream()
                .map(seller -> new UserIdentificationDto(seller.getId(), seller.getName()))
                .toList();

        return new UserFollowedDto(followerUserId, followerName, sellerDtos);
    }

    public static List<User> getUsersToFollow() {
        return List.of(
                UserFactory.createUserCharlie(),
                UserFactory.createUserFrank()
        );
    }

    public static MockHttpServletRequestBuilder createPostRequest(String url, Object... params) {
        return post(url, params).contentType(TestConstants.APPLICATION_JSON);
    }

    public static MockHttpServletRequestBuilder createGetRequest(String url, Object... params) {
        return get(url, params).contentType(TestConstants.APPLICATION_JSON);
    }

    public static ResultMatcher jsonResponse(Object response) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return content().json(objectMapper.writeValueAsString(response));
    }

    public static ExceptionDto exceptionResponse(String message) {
        return new ExceptionDto(message);
    }

    public static void assertResponse(MockMvc mockMvc, MockHttpServletRequestBuilder request, ResultMatcher status, Object expectedResponse) throws Exception {
        ResultActions result = mockMvc.perform(request)
                .andExpect(status)
                .andExpect(TestConstants.CONTENT_TYPE_JSON)
                .andDo(print());

        if (expectedResponse != null) {
            result.andExpect(jsonResponse(expectedResponse));
        }
    }

    public static void createBackup(String file, String backupFile) throws IOException {
        Path original = Path.of("src/test/resources/" + file);
        Path backup = Path.of("src/test/resources/" + backupFile);
        Files.copy(backup, original, StandardCopyOption.REPLACE_EXISTING);
    }

}