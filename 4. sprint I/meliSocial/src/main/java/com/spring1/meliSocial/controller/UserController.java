package com.spring1.meliSocial.controller;

import com.spring1.meliSocial.dto.response.ResponseDto;
import com.spring1.meliSocial.dto.response.UserFollowersDto;
import com.spring1.meliSocial.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("{userId}/followers/list")
    public ResponseEntity<?> getFollowersFromSeller(@PathVariable int userId, @RequestParam(value = "order", defaultValue = "name_asc") String orderMethod) {
        return new ResponseEntity<>(userService.getFollowersFromSeller(userId, orderMethod), HttpStatus.OK);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDto> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(userService.unfollowUser(userId,userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("{userId}/followed/list")
    public ResponseEntity<?> getFollowedByUser(@PathVariable int userId, @RequestParam(value = "order", defaultValue = "name_asc") String orderMethod) {
        return new ResponseEntity<>(userService.getFollowedByUser(userId, orderMethod), HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<UserFollowersDto> getFollowerCount(@PathVariable int userId) {
        return new ResponseEntity<>(userService.findFollowers(userId), HttpStatus.OK);
    }

    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("{userId}/favourite-post/{postId}")
    public ResponseEntity<?> addFavouritePost(@PathVariable int userId, @PathVariable int postId){
        return new ResponseEntity<>(userService.addFavouritePost(userId, postId), HttpStatus.OK);
    }

    @DeleteMapping("{userId}/favourite-post/{postId}")
    public ResponseEntity<?> removeFavouritePost(@PathVariable int userId, @PathVariable int postId){
        userService.removeFavouritePost(userId, postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{userId}/favourite-post")
    public ResponseEntity<?> getFavouritesPosts(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFavouritePostsFromUser(userId), HttpStatus.OK);
    }
}
