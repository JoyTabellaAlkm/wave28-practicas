package com.mercadolibre.socialmeli_g3.controller;

import com.mercadolibre.socialmeli_g3.dto.FollowedListDTO;
import com.mercadolibre.socialmeli_g3.dto.FollowersListDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FollowDTO;
import com.mercadolibre.socialmeli_g3.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // US 004 / 008
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> getSellersFollowedByUser(@PathVariable int userId, @RequestParam (required = false) String order){
        return new ResponseEntity<>(userService.followedOrderBy(userId, order), HttpStatus.OK);
    }

    // US 003 / 008
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getSellersFollowersByUser(@PathVariable int userId, @RequestParam (required = false) String order){
        return new ResponseEntity<>(userService.followersOrderBy(userId, order), HttpStatus.OK);
    }

    // US 002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getControllerFollowers(@PathVariable int userId){
        return new ResponseEntity<> (userService.getNumberFollowers(userId), HttpStatus.OK);
    }

    // US 018 - BONUS
    @GetMapping("/{userId}/followers")
    public ResponseEntity<FollowersListDTO> getFollowersByUsername(@PathVariable int userId, @RequestParam String username){
        return new ResponseEntity<>(userService.getFollowersByUsername(userId,username),HttpStatus.OK);
    }

    // US 007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    // US 001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDTO> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

}
