package com.mercadolibre.social.controller;

import com.mercadolibre.social.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/users"))
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    //01, Poder realizar la acción de “Follow” (seguir) a un determinado usuario
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return ResponseEntity.ok().body(userService.followUser(userId, userIdToFollow));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followersByUser(@PathVariable Integer userId, @RequestParam(value = "order", defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.followersByUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(userService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> followedByUser(@PathVariable Integer userId, @RequestParam(value = "order", defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.followedByUser(userId, order), HttpStatus.OK);
    }

    // 02. Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getCountFollowers(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getCountFollowers(userId), HttpStatus.OK);
    }
}
