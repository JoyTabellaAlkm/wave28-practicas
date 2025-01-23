package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.request.PostDto;
import com.bootcamp.socialmeli.dto.response.ResponseMessageDto;
import com.bootcamp.socialmeli.service.IPostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/products")
public class PostController {
    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> publishNewPromotionalProduct(@RequestBody @Valid PostDto newPost) {
        return new ResponseEntity<ResponseMessageDto>(postService.publishPost(newPost, true), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> publishPost(@RequestBody @Valid PostDto newPost) {
        return new ResponseEntity<ResponseMessageDto>(postService.publishPost(newPost, false), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> listFollowedPosts(@PathVariable int userId, @RequestParam(required = false, defaultValue = "date_desc") String order) {
        return new ResponseEntity<>(postService.getRecentFollowedPosts(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> showUserPromoCount(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(postService.getUserPromoCount(userId), HttpStatus.OK);
    }
}
