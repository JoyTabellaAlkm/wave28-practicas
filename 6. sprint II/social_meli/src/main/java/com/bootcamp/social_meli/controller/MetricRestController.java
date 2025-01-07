package com.bootcamp.social_meli.controller;

import com.bootcamp.social_meli.controller.swagger.IMetricRestController;
import com.bootcamp.social_meli.dto.response.MostFollowersResponseDTO;
import com.bootcamp.social_meli.dto.response.MostProductsResponseDTO;
import com.bootcamp.social_meli.dto.response.MostPostsUsersResponseDTO;
import com.bootcamp.social_meli.dto.response.UserDetailsResponseDTO;
import com.bootcamp.social_meli.service.IProductService;
import com.bootcamp.social_meli.service.IPostService;
import com.bootcamp.social_meli.service.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/metrics")
@Tag(name = "Métricas", description = "Operaciones relacionadas con métricas de usuarios y productos.")
public class MetricRestController implements IMetricRestController {

    private final IUserService userService;
    private final IPostService postService;
    private final IProductService productService;

    @Autowired
    public MetricRestController(IUserService userService, IPostService postService, IProductService productService) {
        this.userService = userService;
        this.postService = postService;
        this.productService = productService;
    }

    @GetMapping("/top/most_followers")
    public ResponseEntity<MostFollowersResponseDTO> getMostFollowersUsers(@RequestParam(required = false) Integer rank) {
        if (rank != null) {
            return ResponseEntity.ok(userService.mostFollowers(rank));
        } else {
            return ResponseEntity.ok(userService.mostFollowers());
        }
    }

    @GetMapping("/{userId}/details")
    public ResponseEntity<UserDetailsResponseDTO> getUserDetails(@PathVariable @Min(value = 1,
            message = "userId debe ser mayor que o igual a 1") Long userId) {
        return ResponseEntity.ok(userService.metricsUserDetails(userId));
    }

    @GetMapping("/top/most_products")
    public ResponseEntity<MostProductsResponseDTO> getMostProductsPosted(@RequestParam(required = false) String rank) {
        if (rank != null) {
            return ResponseEntity.ok(productService.getMostProducts(rank));
        } else {
            return ResponseEntity.ok(productService.getMostProducts());
        }
    }

    @GetMapping("/top/most_posts")
    public ResponseEntity<MostPostsUsersResponseDTO> getMostsPostsUsers(@RequestParam(required = false) Integer rank) {
        if (rank != null) {
            return ResponseEntity.ok(postService.mostPostsUsers(rank));
        } else {
            return ResponseEntity.ok(postService.mostPostsUsers());
        }
    }
}