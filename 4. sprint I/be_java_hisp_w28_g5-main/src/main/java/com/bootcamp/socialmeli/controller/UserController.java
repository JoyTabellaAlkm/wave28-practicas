package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.response.UnfollowResponseDTO;
import com.bootcamp.socialmeli.dto.response.FollowerCountDTO;
import com.bootcamp.socialmeli.dto.UserDto;
import com.bootcamp.socialmeli.dto.request.UserCreationReqDto;
import com.bootcamp.socialmeli.dto.response.GetFollowedDTO;
import com.bootcamp.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersByUser(@PathVariable Long userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(userService.getFollowersByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Long userId,@PathVariable Long userIdToFollow){
        return new ResponseEntity<>( userService.followUser(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO>getFollowerCount(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId),HttpStatus.OK);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<UserDto>> createUsers(@RequestBody List<UserCreationReqDto> usersDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUsers(usersDto));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<GetFollowedDTO> getFollowedUsers(@PathVariable Long userId,
                                                           @RequestParam Optional<String> order){
        return new ResponseEntity<>(userService.getFollowedByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UnfollowResponseDTO> unfollowUser(@PathVariable Long userId,
                                                            @PathVariable Long userIdToUnfollow){
        return new ResponseEntity<>(userService.unfollowUser(userId,userIdToUnfollow),HttpStatus.OK);
    }
    @DeleteMapping("/{userId}/posts")
    public ResponseEntity<Void> deletePost(@PathVariable Long userId) {
        userService.deletePostsByUser(userId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/followers/max")
    public ResponseEntity<FollowerCountDTO> maxFollowersUser(){
        return new ResponseEntity<>(userService.getMaxFollowersCount(), HttpStatus.OK);
    }
}
