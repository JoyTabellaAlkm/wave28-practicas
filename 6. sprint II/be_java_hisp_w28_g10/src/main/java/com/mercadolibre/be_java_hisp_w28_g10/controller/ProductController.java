package com.mercadolibre.be_java_hisp_w28_g10.controller;

import com.mercadolibre.be_java_hisp_w28_g10.dto.post.PostDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.post.ProductDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponsePostNoPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ProductsWithPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.follow.ResponseFollowedPostsDTO;
import com.mercadolibre.be_java_hisp_w28_g10.service.IProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing product-related actions and operations.
 * <p>
 * This controller exposes RESTful endpoints for managing products and posts,
 * including functionalities to retrieve, add, and manipulate promotional and regular posts.
 * </p>
 */
@RestController
@Validated
@RequestMapping("/products/")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * Endpoint to retrieve all products.
     *
     * @return ResponseEntity containing a list of all products as {@link List<PostDTO>} and an HTTP status code.
     */
    @GetMapping("getAll")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    /**
     * US 0005
     * Endpoint to add a new post.
     *
     * @param post the {@link PostDTO} object containing the details of the post to be added.
     * @return ResponseEntity containing the result of the add operation as {@link ResponsePostNoPromoDTO} and an HTTP status code.
     */
    @PostMapping("post")
    public ResponseEntity<ResponsePostNoPromoDTO> addPost(@RequestBody @Valid PostDTO post) {
        return new ResponseEntity<>(productService.addPost(post), HttpStatus.OK);
    }

    /**
     * US 0010
     * Endpoint to create a new promotional post.
     *
     * @param promoPost the {@link PostDTO} object containing the information for the new post.
     * @return ResponseEntity<PostDTO> containing the created post and an HTTP status code.
     */
    @PostMapping("promo-post")
    public ResponseEntity<PostDTO> addPromoPost(@RequestBody @Valid PostDTO promoPost) {
        return new ResponseEntity<>(productService.addPromoPost(promoPost), HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve all posts.
     *
     * @return ResponseEntity containing a list of all posts as {@link List<PostDTO>} and an HTTP status code.
     */
    @GetMapping("post/getAll")
    public ResponseEntity<List<PostDTO>> getAllPost() {
        return new ResponseEntity<>(productService.getAllPost(), HttpStatus.OK);
    }

    /**
     * US 0011
     * Endpoint to count promotional products for a specific user.
     *
     * @param user_id the ID of the user for whom to count promotional products.
     * @return ResponseEntity<ProductsWithPromoDTO> containing the count of promotional products and an HTTP status code.
     */
    @GetMapping("promo-post/count")
    public ResponseEntity<ProductsWithPromoDTO> getPromoProductCountByUserId(@RequestParam
                                                                             @Positive(message = "El id debe ser mayor a cero.")
                                                                             Integer user_id) {
        return new ResponseEntity<>(productService.productsWithPromoDTO(user_id), HttpStatus.OK);
    }

    /**
     * US 0006 + US 0009
     * Endpoint to retrieve the list of the last followed posts for a specific user.
     *
     * @param userId the ID of the user whose followed posts are to be retrieved.
     * @param order  optional parameter to specify the order in which the posts should be returned (can be null).
     * @return ResponseEntity<ResponseFollowedPostsDTO> containing the list of followed posts and an HTTP status code.
     */
    @GetMapping("followed/{userId}/list")
    public ResponseEntity<ResponseFollowedPostsDTO> getLastFollowedPosts(@PathVariable @Positive(message = "El id debe ser mayor a cero.") int userId,
                                                                         @RequestParam(defaultValue = "") String order) {
        return new ResponseEntity<>(productService.getLastFollowedPosts(userId, order), HttpStatus.OK);
    }
}
