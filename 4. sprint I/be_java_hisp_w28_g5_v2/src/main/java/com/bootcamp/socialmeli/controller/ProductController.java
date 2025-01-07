package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.PostPromoDto;
import com.bootcamp.socialmeli.dto.PromoProductsCountDto;
import com.bootcamp.socialmeli.dto.request.PostPromoRequestDto;
import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.response.GetFollowedProductsDto;
import com.bootcamp.socialmeli.service.ProductService;
import com.bootcamp.socialmeli.util.validate.DtoValidatorPost;
import com.bootcamp.socialmeli.util.validate.DtoValidatorPromoPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<GetFollowedProductsDto> getFollowedProducts(@PathVariable Long userId, @RequestParam Optional<String> order) {
        return new ResponseEntity<>(productService.followedProducts(userId, order), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<PostDto> postPostProduct(@RequestBody PostCreationDto postDto){
        DtoValidatorPost.validatePostCreationReqDto(postDto);
        return ResponseEntity.status(HttpStatus.OK).body(productService.createPost(postDto));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoDto> postPostWithDiscount(@RequestBody PostPromoRequestDto postPromoDto){
        DtoValidatorPromoPost.validatePromoPostCreation(postPromoDto);
        return ResponseEntity.status(HttpStatus.OK).body(productService.createPostWithDiscount(postPromoDto));
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDto> getPromoProductsCount(@RequestParam("user_id") Long id){
        return new ResponseEntity<>(productService.getPromoProductCount(id),HttpStatus.OK);
    }
}
