package com.mercadolibre.social.controller;

import com.mercadolibre.social.dto.request.PostPromotionRequestDto;
import com.mercadolibre.social.dto.request.PostRequestDto;
import com.mercadolibre.social.service.IPostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("products/post")
    public ResponseEntity<?> createPost(@RequestBody @Valid PostRequestDto postRequestDTO) {
        return new ResponseEntity<>(postService.createPost(postRequestDTO), HttpStatus.OK);
    }

    // 11. Obtener la cantidad de productos en promoción de un determinado vendedor ?user_id={userId}
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getCountPromoPost(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(postService.getCountPromoPost(userId), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> createPostPromotion(@RequestBody @Valid PostPromotionRequestDto postPromotionRequestDto) {
        return new ResponseEntity<>(postService.createPostPromotion(postPromotionRequestDto), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> getPostsByFollowedUsers(@PathVariable Integer userId,
                                                     @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity<>(postService.getPostsByFollowedUsers(userId, order), HttpStatus.OK);
    }

}
