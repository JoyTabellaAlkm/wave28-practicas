package com.api.social_meli.controller;

import com.api.social_meli.dto.PostDto;
import com.api.social_meli.dto.PromoPostDto;
import com.api.social_meli.dto.FollowedSellerPostsDto;
import com.api.social_meli.service.IPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IPostService postService;

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoProductCount(
            @RequestParam("user_id") Integer userId) {
        return new ResponseEntity<>(postService.getPromoProductCount(userId), HttpStatus.OK);
    }

    /**
     * USER STORY 0006: Obtiene un listado de las publicaciones realizadas por los vendedores que
     * un usuario sigue en las últimas dos semanas
     *
     * @param userId Usuario cuyos seguidores hay que verificar publicaciones
     * @param order Establece orden ascendiente o descendiente
     * @return 200 OK, Lista de posts generados por los vendedores que sigue el usuario mandado
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedSellerPostsDto> getFollowedSellersPosts(
            @PathVariable int userId,
            @RequestParam (required = false) String order) {
        return new ResponseEntity<>(postService.getFollowedSellersPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(
            @Valid @RequestBody PromoPostDto dto) {
        return new ResponseEntity<>(postService.createPromoPost(dto), HttpStatus.OK);
    }

    /**
     * USER STORY 0005: Da de alta a un post
     * @param dto Datos de la publicacion a generar
     * @return 200 OK, Mensaje de publicacion con exito
     */
    @PostMapping("/post")
    public ResponseEntity<?> createPost(
            @Valid @RequestBody PostDto dto) {
        return new ResponseEntity<>(postService.createPost(dto), HttpStatus.OK);
    }
}
