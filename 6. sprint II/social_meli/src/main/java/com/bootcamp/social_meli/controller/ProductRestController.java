package com.bootcamp.social_meli.controller;

import com.bootcamp.social_meli.controller.swagger.IProductRestController;
import com.bootcamp.social_meli.dto.request.PostDTO;
import com.bootcamp.social_meli.dto.request.PromoPostDTO;
import com.bootcamp.social_meli.dto.response.AmountOfPromosResponseDTO;
import com.bootcamp.social_meli.dto.response.PostsFromFollowsResponseDTO;
import com.bootcamp.social_meli.dto.response.PostsWithProductResponseDTO;
import com.bootcamp.social_meli.dto.response.UserPostResponse;
import com.bootcamp.social_meli.service.IPostService;
import com.bootcamp.social_meli.service.IProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@Validated
@RequestMapping("/products")
@Tag(name = "Gestión de Productos", description = "Operaciones relacionadas con los productos.")
public class ProductRestController implements IProductRestController {

    private final IPostService postService;
    private final IProductService productService;

    @Autowired
    public ProductRestController(IPostService postService, IProductService productService) {
        this.postService = postService;
        this.productService = productService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsFromFollowsResponseDTO> getAllPostsFollowsLastTwoWeeks(
            @Parameter(description = "ID del usuario actual") @PathVariable @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId,
            @RequestParam(defaultValue = "date_asc") String order) {
        return new ResponseEntity<>(productService.getAllPostsFollowsLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<UserPostResponse> postProduct(@Valid @RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }


    @PostMapping("/promo-post")
    public ResponseEntity<UserPostResponse> createPromoPost(@Valid @RequestBody PromoPostDTO promoPostDTO) {
        return ResponseEntity.ok(postService.createPromoPost(promoPostDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<AmountOfPromosResponseDTO> getAmountOfPromosByUser(@RequestParam Long user_id) {
        return ResponseEntity.ok(productService.getAmountOfPromosByUser(user_id));
    }

    @GetMapping("/posts/search")
    public ResponseEntity<PostsWithProductResponseDTO> getPostsWithProduct(@RequestParam String name) {
        return ResponseEntity.ok(postService.getPostsWithProduct(name));
    }

    @GetMapping("/posts/prices")
    public ResponseEntity<List<PostDTO>> getPostsByPriceRange(@RequestParam String min, @RequestParam String max) {
        return ResponseEntity.ok(postService.getPostsByPriceRange(min, max));
    }
}
