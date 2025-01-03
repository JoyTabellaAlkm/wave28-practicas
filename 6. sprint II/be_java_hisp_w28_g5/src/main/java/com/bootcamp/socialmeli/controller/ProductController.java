package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.PostPromoDto;
import com.bootcamp.socialmeli.dto.PromoProductsCountDto;
import com.bootcamp.socialmeli.dto.request.PostPromoRequestDto;
import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.response.GetFollowedProductsDto;
import com.bootcamp.socialmeli.service.ProductService;
import com.bootcamp.socialmeli.util.validation.message.ValidationMessage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
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
    public ResponseEntity<GetFollowedProductsDto> getFollowedProducts(
            @PathVariable
            @Min(value=1, message= ValidationMessage.MIN_USER_ID)
            Long userId,
            @RequestParam(required = false)
            @Pattern(regexp = "^(date_asc|date_desc)$", message = ValidationMessage.INVALID_SORT_ORDER)
            String order) {
        return new ResponseEntity<>(productService.followedProducts(userId, Optional.ofNullable(order)), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<PostDto> postPostProduct(@RequestBody @Valid PostCreationDto postDto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.createPost(postDto));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoDto> postPostWithDiscount(@RequestBody @Valid PostPromoRequestDto postPromoDto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.createPostWithDiscount(postPromoDto));
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDto> getPromoProductsCount(
            @Min(value=1, message=ValidationMessage.MIN_USER_ID)
            @RequestParam("user_id")
            Long id){
        return new ResponseEntity<>(productService.getPromoProductCount(id),HttpStatus.OK);
    }
}
