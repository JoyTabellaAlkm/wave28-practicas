package com.mercadolibre.be_java_hisp_w28_g10.service;

import com.mercadolibre.be_java_hisp_w28_g10.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.ProductDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.ResponseFollowedPostsDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponsePostNoPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ProductsWithPromoDTO;
import com.mercadolibre.be_java_hisp_w28_g10.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Interface for managing product and post-related operations within the application.
 * This interface defines methods to retrieve products and posts, validate user input, and manage
 * promotional posts. Implementations of this interface are responsible for the business logic
 * related to products and posts.
 */
public interface IProductService {
    /**
     * Retrieves all products in the system.
     *
     * @return a List of {@link ProductDTO} containing the details of all products.
     */
    List<ProductDTO> getAllProducts();

    /**
     * Retrieves all posts in the system.
     *
     * @return a List of {@link PostDTO} containing the details of all posts.
     */
    List<PostDTO> getAllPost();

    /**
     * Adds a regular post to the system.
     *
     * @param post the {@link PostDTO} containing the details of the post to be added.
     * @return a {@link ResponsePostNoPromoDTO} containing the details of the added post.
     */
    ResponsePostNoPromoDTO addPost(PostDTO post);

    /**
     * Adds a promotional post to the system.
     * @param promoPost the {@link PostDTO} containing the details of the post to be added.
     * @return the added {@link PostDTO}.
     */
    PostDTO addPromoPost(PostDTO promoPost);

    /**
     * Retrieves the number of promotional products associated with a specified user.
     * @param id the ID of the user.
     * @return a {@link ProductsWithPromoDTO} containing the user's ID, name, and the count of promotional products.
     * @throws NotFoundException if the user is not found or if there are no posts.
     */
    ProductsWithPromoDTO productsWithPromoDTO(int id);

    /**
     * Retrieves the most recent posts from users that the specified user follows.
     * @param userId the ID of the user requesting the posts.
     * @param order optional sorting order for the posts (asc/desc).
     * @return a {@link ResponseFollowedPostsDTO} containing the user's ID and a list of the most recent posts.
     * @throws NotFoundException if there are no posts from followed users in the last two weeks.
     * @throws BadRequestException if the user follows no one or if the order parameter is invalid.
     */
    public ResponseFollowedPostsDTO getLastFollowedPosts(Integer userId, Optional<String> order);
}
