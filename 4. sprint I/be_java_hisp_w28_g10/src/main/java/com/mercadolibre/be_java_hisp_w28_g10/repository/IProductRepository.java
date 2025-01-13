package com.mercadolibre.be_java_hisp_w28_g10.repository;

import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w28_g10.model.Post;
import com.mercadolibre.be_java_hisp_w28_g10.model.Product;

import java.util.List;

/**
 * Interface for managing product and post-related data operations.
 * This repository interface provides methods for retrieving product and post information,
 * checking the existence of products, and adding new products and posts.
 */
public interface IProductRepository {
    /**
     * Retrieves a list of all products in the repository.
     *
     * @return a List of {@link Product} representing all products.
     */
    List<Product> findAll();

    /**
     * Retrieves a list of all posts in the repository.
     *
     * @return a List of {@link Post} representing all posts.
     */
    List<Post> findAllPost();

    /**
     * Checks if a product exists in the repository based on its ID.
     *
     * @param productId the ID of the product to check for existence.
     * @return true if the product exists; false otherwise.
     */
    boolean existsProduct(int productId);

    /**
     * Adds a new product to the repository.
     *
     * @param product the {@link Product} to be added.
     * @return true if the product was added successfully; false otherwise.
     */
    boolean addProduct(Product product);

    /**
     * Adds a new post to the repository.
     *
     * @param post the {@link Post} to be added.
     * @return true if the post was added successfully; false otherwise.
     */
    boolean addPost(Post post);
    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve.
     * @return the corresponding {@link Product} object.
     * @throws NotFoundException if the product is not found.
     */
    Product getProductById(int id);
}
