package com.api.social_meli.controller;

import com.api.social_meli.dto.GetByCategoryResponseDto;
import com.api.social_meli.dto.PostDto;
import com.api.social_meli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    IPostService postService;

    @GetMapping("{categoryId}/category/list/{price_min}/{price_max}")
    public ResponseEntity<GetByCategoryResponseDto> getCategoryList(@PathVariable int categoryId, @PathVariable double price_min, @PathVariable double price_max) {
            return new ResponseEntity<>(postService.getPostByCategoryId(categoryId, price_min,price_max),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<PostDto>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }
}
