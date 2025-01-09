package com.bootcamp.socialmeli.integration.controller;

import com.bootcamp.socialmeli.dto.request.GoalDto;
import com.bootcamp.socialmeli.dto.response.*;
import com.bootcamp.socialmeli.entity.Goal;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.factory.GoalFactory;
import com.bootcamp.socialmeli.factory.UserFactory;
import com.bootcamp.socialmeli.utils.TestConstants;
import com.bootcamp.socialmeli.utils.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;
import java.util.List;

import static com.bootcamp.socialmeli.utils.TestConstants.*;
import static com.bootcamp.socialmeli.utils.TestUtil.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    public void tearDown() throws Exception {
        TestUtil.createBackup("users.json", "users_backup.json");
        TestUtil.createBackup("goals.json", "goals_backup.json");
    }

    @Test
    public void givenValidUserAndValidSeller_whenFollowSeller_thenUserFollowsSellerSuccessfully() throws Exception {
        //ARRANGE
        User followerUser = UserFactory.createUserBob();
        int followerUserId = followerUser.getId();

        User sellerToFollow = UserFactory.createUserCharlie();
        int sellerIdToFollow = sellerToFollow.getId();

        List<User> sellersToFollow = TestUtil.getUsersToFollow();

        UserFollowedDto expectedUserFollowedDto = TestUtil.createUserFollowedDto(followerUserId,
                followerUser.getName(),
                sellersToFollow);

        MockHttpServletRequestBuilder followSellerRequest = TestUtil.createPostRequest(
                "/users/{userId}/follow/{userIdToFollow}",
                followerUserId,
                sellerIdToFollow
        );

        //ACT & ASSERT
        TestUtil.assertResponse(mockMvc,
                followSellerRequest,
                STATUS_OK,
                expectedUserFollowedDto);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5, 'Ya sigue al usuario'",
            "1, 50, 'No existe usuario con ese id'"
    })

    void givenDifferentScenarios_whenFollowSeller_thenHandleResponse(int userId, int sellerId, String expectedMessage) throws Exception {

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest(
                "/users/{userId}/follow/{userIdToFollow}", userId, sellerId);

        TestUtil.assertResponse(
                mockMvc,
                request,
                expectedMessage.equals("Ya sigue al usuario") ? TestConstants.STATUS_BAD_REQUEST : TestConstants.STATUS_NOT_FOUND,
                exceptionResponse(expectedMessage)
        );
    }

    @Test
    public void givenValidSeller_whenGetFollowers_thenReturnFollowersSuccessfully() throws Exception {
        //ASSERT
        User createUserAlice = UserFactory.createUserAlice();
        UserFollowersCountResponseDto userFollowersCountResponseDto = new UserFollowersCountResponseDto(
                createUserAlice.getId(),
                createUserAlice.getName(),
                createUserAlice.followersCount());

        MockHttpServletRequestBuilder request = TestUtil.createGetRequest("/users/{userId}/followers/count",
                createUserAlice.getId());

        //ACT && ASSERT
        assertResponse(mockMvc,
                request,
                STATUS_OK,
                userFollowersCountResponseDto);
    }

    @Test
    public void givenInvalidSeller_whenGetFollowers_thenReturnNotFound() throws Exception {

        MockHttpServletRequestBuilder request = get("/users/{userId}/followers/count", USER_ID_NOT_EXIST);

        testIfUserExistsThrowException(request);
    }

    @Test
    void givenValidSeller_whenGetFollowersList_thenReturnFollowersSuccessfully() throws Exception {
        //ARRANGE
        User getUserSeller = UserFactory.createUserJack();
        UserFollowingSellerResponseDto userFollowingSellerResponseDto = new UserFollowingSellerResponseDto(
                getUserSeller.getId(),
                getUserSeller.getName(),
                List.of()
        );

        MockHttpServletRequestBuilder request = TestUtil.createGetRequest("/users/{userId}/followers/list",
                getUserSeller.getId());

        //ART && ASSERT
        assertResponse(mockMvc, request,
                STATUS_OK,
                userFollowingSellerResponseDto);

    }

    @Test
    void givenInvalidSeller_whenGetFollowersList_thenReturnNotFound() throws Exception {

        MockHttpServletRequestBuilder request = get("/users/{userId}/followers/list", USER_ID_NOT_EXIST);

        //ART && ASSERT
        testIfUserExistsThrowException(request);

    }

    @Test
    void givenValidUser_whenGetFollowedSellersList_thenReturnSellersSuccessfully() throws Exception {
        //ARRANGE
        User user = UserFactory.createUserJack();

        UserFollowedDto expectedUserFollowedDto = new UserFollowedDto(
                user.getId(),
                user.getName(),
                List.of()
        );

        MockHttpServletRequestBuilder request = TestUtil.createGetRequest("/users/{userId}/followed/list", user.getId());

        //ART && ASSERT
        assertResponse(mockMvc,
                request,
                STATUS_OK,
                expectedUserFollowedDto);
    }

    @Test
    void givenInvalidUser_whenGetFollowedSellersList_thenReturnNotFound() throws Exception {

        MockHttpServletRequestBuilder request = get("/users/{userId}/followed/list", USER_ID_NOT_EXIST);

        //ART && ASSERT
        testIfUserExistsThrowException(request);

    }

    @Test
    void givenValidUserAndSeller_whenUnfollowSeller_thenUnfollowSuccessfully() throws Exception {
        //ARRANGE
        int userId = 1;
        int userIdToUnfollow = 2;
        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/users/{userId}/unfollow/{userIdToUnfollow}",
                userId,
                userIdToUnfollow);

        //ART && ASSERT
        assertResponse(mockMvc,
                request,
                STATUS_NO_CONTENT,
                null);

    }

    @ParameterizedTest
    @CsvSource({
            "1, 10, 'No está siguiendo al usuario'",
            "50, 1, 'No existe usuario con ese id'"
    })
    void givenDifferentScenarios_whenUnfollowSeller_thenHandleResponse(int userId, int userIdToUnfollow, String expectedMessage) throws Exception {

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/users/{userId}/unfollow/{userIdToUnfollow}",
                userId,
                userIdToUnfollow);

        assertResponse(
                mockMvc,
                request,
                expectedMessage.equals("No está siguiendo al usuario") ? TestConstants.STATUS_BAD_REQUEST : TestConstants.STATUS_NOT_FOUND,
                exceptionResponse(expectedMessage)
        );
    }

    @Test
    void givenValidUser_whenSaveGoals_thenGoalsSavedSuccessfully() throws Exception {
        //ARRANGE
        User user = UserFactory.createUserBob();
        Goal newGoalToSave = GoalFactory.createGoal();

        GoalDto goalToSaveDto = new GoalDto(
                newGoalToSave.getId(),
                newGoalToSave.getName(),
                newGoalToSave.getTargetFollowers(),
                newGoalToSave.getDeadline()
        );

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/users/{userId}/goal", user.getId())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(goalToSaveDto));

        //ART && ASSERT
        assertResponse(
                mockMvc,
                request,
                STATUS_CREATED,
                null);
    }

    @ParameterizedTest
    @CsvSource({
            "11, 1, 'Un goal con ese id ya existe'",
            "50, 11, 'No existe usuario con ese id'"
    })
    void givenDifferentScenarios_whenSaveGoals_thenHandleResponse(int userId, int goalId, String expectedMessage) throws Exception {

        //ARRANGE
        GoalDto goalToSaveDto = new GoalDto(goalId,
                "20 followers",
                5,
                LocalDate.of(2025, 10, 02)
        );

        MockHttpServletRequestBuilder request = TestUtil.createPostRequest("/users/{userId}/goal", userId)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(goalToSaveDto));

        //ART && ASSERT
        assertResponse(
                mockMvc,
                request,
                expectedMessage.equals("Un goal con ese id ya existe") ? TestConstants.STATUS_BAD_REQUEST : TestConstants.STATUS_NOT_FOUND,
                exceptionResponse(expectedMessage)
        );
    }

    @Test
    void givenValidUser_whenGetGoals_thenGoalsSuccessfully() throws Exception {
        //ARRANGE
        User user = UserFactory.createUserFrank();
        Goal goal = user.getGoal();

        MockHttpServletRequestBuilder request = TestUtil.createGetRequest("/users/{userId}/goal", user.getId());

        //ART && ASSERT
        assertResponse(mockMvc,
                request,
                STATUS_OK,
                null
        );
    }

    private void testIfUserExistsThrowException(MockHttpServletRequestBuilder request) throws Exception {
        assertResponse(mockMvc,
                request,
                STATUS_NOT_FOUND,
                jsonResponse(exceptionResponse("No existe usuario con ese id")));
    }

}

