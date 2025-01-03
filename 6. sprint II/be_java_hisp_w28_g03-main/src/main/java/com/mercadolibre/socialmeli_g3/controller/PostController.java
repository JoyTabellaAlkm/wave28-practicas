package com.mercadolibre.socialmeli_g3.controller;

import com.mercadolibre.socialmeli_g3.dto.response.PostDTO;
import com.mercadolibre.socialmeli_g3.dto.PromoProductPostDTO;
import com.mercadolibre.socialmeli_g3.dto.response.PromoProductPostListDTO;
import com.mercadolibre.socialmeli_g3.dto.response.ProductByIdUserResponseDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FindProductsPromoResponseDTO;
import com.mercadolibre.socialmeli_g3.dto.ProductPostDTO;
import com.mercadolibre.socialmeli_g3.service.IPostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts(){
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    // US006 - US009
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<ProductByIdUserResponseDTO> findProductByIdUser(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<ProductByIdUserResponseDTO>(postService.findProductByIdUser(userId, order), HttpStatus.OK);
    }

    // US0015
    @GetMapping("/products/filter")
    public ResponseEntity<List<PostDTO>> findProductByPrice(@RequestParam double minPrice, @RequestParam double maxPrice){
        return new ResponseEntity<List<PostDTO>>(postService.findProductByPrice(minPrice,maxPrice), HttpStatus.OK);
    }

    // US0011
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<FindProductsPromoResponseDTO> findProductsPromoCount(@RequestParam int user_id){
        return new ResponseEntity<FindProductsPromoResponseDTO>(postService.findProductsPromoCount(user_id), HttpStatus.OK);
    }

    // US0005
    @PostMapping("/products/post")
    public ResponseEntity<?> createPost(@Valid @RequestBody ProductPostDTO productPostDTO){
        return new ResponseEntity<>(postService.createPost(productPostDTO),HttpStatus.OK);
    }

    // US0010
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> createPromoPost(@Valid @RequestBody PromoProductPostDTO promoProductPostDTO){
        return new ResponseEntity<>(postService.createPromoPost(promoProductPostDTO),HttpStatus.OK);
    }

    // US0012
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromoProductPostListDTO> findProductsOnPromoByUser(@RequestParam String user_id){
        return new ResponseEntity<>(postService.getProductsOnPromoByUser(user_id), HttpStatus.OK);
    }

    // US0017
    @GetMapping("/products/posts/by-product-attributes/")
    public ResponseEntity<List<PostDTO>> findProductsByProductAttributes(@RequestParam Map<String, String> filterParams) {
        return new ResponseEntity<>(postService.getPostsByProductAttributes(filterParams), HttpStatus.OK);
    }
    // US 0016
    @GetMapping ("/products/post/category/{category}")
    public ResponseEntity<?> findProductByCategory(@PathVariable  int category){
        return new ResponseEntity<>(postService.findProductsByCategory(category), HttpStatus.OK);
    }

    // US 0013
    @PutMapping("/products/post/{postId}")
    public ResponseEntity<PromoProductPostDTO> makePostAPromo(@PathVariable int postId, @RequestParam double discount){
        return new ResponseEntity<>(postService.makePostAPromo(postId,discount), HttpStatus.OK);
    }
}
