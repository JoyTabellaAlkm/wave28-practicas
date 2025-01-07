package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.PostPromoDto;
import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostPromoDto>> getPosts(@RequestParam Optional<Integer> category){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPosts(category));
    }
    @PostMapping("/createMultiple")
    public ResponseEntity<List<PostDto>> createPosts(@RequestBody List<PostCreationDto> postsDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPosts(postsDto));
    }

}
