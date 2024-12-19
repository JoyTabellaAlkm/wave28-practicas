package com.mercadolibre.be_java_hisp_w28_g10.controller;

import com.mercadolibre.be_java_hisp_w28_g10.dto.*;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponseMessageDTO;
import com.mercadolibre.be_java_hisp_w28_g10.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for managing user-related actions and interactions.
 * <p>
 * This controller handles HTTP requests for user operations,
 * including retrieving user information, following/unfollowing users,
 * and managing follow relationships.
 * </p>
 */
@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * Endpoint to retrieve all users.
     *
     * @return ResponseEntity containing a list of all users as {@link List<UserDTO>} and an HTTP status code.
     */
    @GetMapping("getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve all follow relations.
     *
     * @return ResponseEntity containing a list of all follow relations as {@link List<FollowRelationDTO>} and an HTTP status code.
     */
    @GetMapping("followRelation/getAll")
    public ResponseEntity<List<FollowRelationDTO>> getAllFollowRelations() {
        return new ResponseEntity<>(userService.getAllFollowRelation(), HttpStatus.OK);
    }

    /**
     * Endpoint to follow a user.
     *
     * @param userId         the ID of the user who is following.
     * @param userIdToFollow the ID of the user to be followed.
     * @return ResponseEntity containing the {@link FollowRelationDTO} of the newly created follow relationship and an HTTP status code.
     */
    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowRelationDTO> addNewFollow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    /**
     * Endpoint to count the number of followers for a user.
     *
     * @param userId the ID of the user whose followers count is to be retrieved.
     * @return ResponseEntity containing {@link FollowersDTO} with the count of followers and an HTTP status code.
     */
    @GetMapping("{userId}/followers/count")
    public ResponseEntity<FollowersDTO> getAmountFollowersById(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getFollowersAmountById(userId), HttpStatus.OK);
    }

    /**
     * Endpoint to unfollow a user.
     *
     * @param userId           the ID of the user who is unfollowing.
     * @param userIdToUnfollow the ID of the user to be unfollowed.
     * @return ResponseEntity containing a {@link ResponseMessageDTO} indicating the result of the unfollow operation and an HTTP status code.
     */
    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseMessageDTO> unfollowUserById(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(userService.unfollowUserById(userId, userIdToUnfollow), HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve the list of followers for a user.
     *
     * @param userId the ID of the user whose followers are to be retrieved.
     * @param order  optional parameter to specify the order in which followers should be returned.
     * @return ResponseEntity containing a {@link UserFollowersDTO} with the list of followers and an HTTP status code.
     */
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getUserFollowersById(@PathVariable int userId, @RequestParam(defaultValue = "") String order) {
        return new ResponseEntity<>(userService.getUserFollowersById(userId, order), HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve the list of users followed by a specific user.
     *
     * @param userId the ID of the user whose following list is to be retrieved.
     * @param order  optional parameter to specify the order in which followed users should be returned.
     * @return ResponseEntity containing a {@link UserFollowersDTO} with the list of followed users and an HTTP status code.
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getUserFollowedById(@PathVariable Integer userId, @RequestParam(defaultValue = "") String order) {
        return new ResponseEntity<>(userService.getUserFollowedById(userId, order), HttpStatus.OK);
    }
}
