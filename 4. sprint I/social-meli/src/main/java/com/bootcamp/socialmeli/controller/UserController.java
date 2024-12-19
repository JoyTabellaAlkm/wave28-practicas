package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.request.GoalDto;
import com.bootcamp.socialmeli.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.socialmeli.dto.response.UserFollowingSellerResponseDto;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(userService.addFollower(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowingList(@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.getFollowingList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(userService.removeFollower(userId, userIdToUnfollow), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}/followers/count")
    ResponseEntity<UserFollowersCountResponseDto> getAllUsersFollowersCount(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getAllUsersFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    ResponseEntity<UserFollowingSellerResponseDto> getAllUsersFollowingSeller(@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.getAllUsersFollowingSeller(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/goal")
    public ResponseEntity<?> setGoal(@PathVariable int userId, @RequestBody GoalDto goalDto) {
        return new ResponseEntity<>(userService.addGoal(userId, goalDto), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/goal")
    public ResponseEntity<?> getGoal(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getGoal(userId), HttpStatus.OK);
    }
}
