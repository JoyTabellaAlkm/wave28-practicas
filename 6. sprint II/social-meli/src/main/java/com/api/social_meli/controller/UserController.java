package com.api.social_meli.controller;

import com.api.social_meli.dto.FavouritePostRequestDto;
import com.api.social_meli.dto.GetFavouritePostsResponseDto;
import com.api.social_meli.dto.MessageDto;
import com.api.social_meli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * USER STORY 0002: Obtiene el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     * @param userId Id del usuario a contar seguidores
     * @return 200 OK, Usuario insertado y cantidad de seguidores
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowerCount(
            @PathVariable int userId) {
        return new ResponseEntity<>(userService.getFollowerCount(userId),HttpStatus.OK);
    }

    /**
     * USER STORY 0007: Realiza la acción de “Unfollow” (dejar de seguir) a un determinado
     * vendedor.
     *
     * @param userId Id del usuario seguidor
     * @param userIdToUnfollow Id del usuario que se dejara de seguir
     * @return 200 OK, Mensaje de usuario dejado de seguir con exito
     */
    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(
            @PathVariable int userId,
            @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(userService.unfollowUser(userId,userIdToUnfollow), HttpStatus.OK);
    }

    /**
     * USER STORY 0003: Obtiene un listado de todos los usuarios que siguen a un determinado vendedor
     * @param userId Id del usuario a revisar seguidores
     * @param order Orden ascendiente o decreciente
     * @return 200 OK, Lista de seguidores de usuario insertado
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(
            @PathVariable int userId,
            @RequestParam (required = false) String order) {
        return new ResponseEntity<>(userService.getFollowersOrderedByName(userId, order), HttpStatus.OK);
    }

    /**
     * USER STORY 0004: Obtiene un listado de todos los vendedores que sigue un determinado usuario
     * @param userId Id del usuario a revisar lo que sigue
     * @param order Orden ascendiente o decreciente
     * @return 200 OK, Lista de seguidos de usuario insertado
     */
    @GetMapping("{userId}/followed/list")
    public ResponseEntity<?> getFollowedsByUserId(
            @PathVariable int userId,
            @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowedsOrderedByName(userId, order), HttpStatus.OK);
    }

    /**
     * USER STORY 0001: Permite realizar la accion de follow a un vendedor
     * @param userId Id del usuario seguidor
     * @param userIdToFollow Id del usuario a seguir
     * @return 200 OK, Mensaje de seguimiento exitoso
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(
            @PathVariable("userId") int userId,
            @PathVariable("userIdToFollow") int userIdToFollow) {
        return new ResponseEntity<>(userService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userService.searchAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/favourites")
    public ResponseEntity<MessageDto> favouritePost(
            @Valid @RequestBody FavouritePostRequestDto request) {
        return ResponseEntity.ok(userService.favouritePost(request));
    }

    @GetMapping("/{userId}/favourites")
    public ResponseEntity<GetFavouritePostsResponseDto> getFavouritePosts(
            @PathVariable("userId") int userId) {
        return ResponseEntity.ok(userService.getFavouritePosts(userId));
    }


    @PostMapping("/unfavourite")
    public ResponseEntity<?> unfavouritePost(
            @Valid @RequestBody FavouritePostRequestDto request) {
        return new ResponseEntity<>(userService.unfavouritePost(request), HttpStatus.OK);
    }
}
