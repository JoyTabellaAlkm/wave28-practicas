package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.response.UnfollowResponseDTO;
import com.bootcamp.socialmeli.dto.response.FollowerCountDTO;
import com.bootcamp.socialmeli.dto.UserDto;
import com.bootcamp.socialmeli.dto.request.UserCreationReqDto;
import com.bootcamp.socialmeli.dto.response.GetFollowedDTO;
import com.bootcamp.socialmeli.service.UserService;
import com.bootcamp.socialmeli.util.validation.message.ValidationMessage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersByUser(
            @PathVariable
            @Min(value=1,message = ValidationMessage.MIN_USER_ID)
            Long userId,
            @RequestParam(required = false)
            @Pattern(regexp = "^(name_asc|name_desc)$", message = ValidationMessage.INVALID_SORT_ORDER)
            String order){
        return new ResponseEntity<>(userService.getFollowersByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable
                                        @Min(value=1,message = ValidationMessage.MIN_USER_ID)
                                            Long userId,
                                        @PathVariable
                                        @Min(value=1,message = ValidationMessage.MIN_USER_ID)
                                        Long userIdToFollow){
        return new ResponseEntity<>( userService.followUser(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO>getFollowerCount(@PathVariable
                                                                @Min(value=1,message = ValidationMessage.MIN_USER_ID)
                                                                Long userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId),HttpStatus.OK);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<UserDto>> createUsers(@RequestBody List<UserCreationReqDto> usersDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUsers(usersDto));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<GetFollowedDTO> getFollowedUsers(
            @PathVariable
            @Min(value=1,message=ValidationMessage.MIN_USER_ID)
            Long userId,
            @RequestParam(required = false)
            @Pattern(regexp = "^(name_asc|name_desc)$", message = ValidationMessage.INVALID_SORT_ORDER)
            String order){
        return new ResponseEntity<>(userService.getFollowedByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UnfollowResponseDTO> unfollowUser(
            @PathVariable
            @Min(value=1,message = ValidationMessage.MIN_USER_ID)
            Long userId,
            @PathVariable
            @Min(value=1,message = ValidationMessage.MIN_USER_ID)
            Long userIdToUnfollow){
        return new ResponseEntity<>(userService.unfollowUser(userId,userIdToUnfollow),HttpStatus.OK);
    }
    @DeleteMapping("/{userId}/posts")
    public ResponseEntity<Void> deletePost(
            @PathVariable
            @Min(value=1, message= ValidationMessage.MIN_USER_ID)
            Long userId) {
        userService.deletePostsByUser(userId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/followers/max")
    public ResponseEntity<FollowerCountDTO> maxFollowersUser(){
        return new ResponseEntity<>(userService.getMaxFollowersCount(), HttpStatus.OK);
    }
}
