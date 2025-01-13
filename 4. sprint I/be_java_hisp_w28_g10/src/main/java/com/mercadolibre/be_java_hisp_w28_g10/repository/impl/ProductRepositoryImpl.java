package com.mercadolibre.be_java_hisp_w28_g10.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.be_java_hisp_w28_g10.exception.LoadJSONDataException;
import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w28_g10.model.Post;
import com.mercadolibre.be_java_hisp_w28_g10.model.Product;
import com.mercadolibre.be_java_hisp_w28_g10.repository.IProductRepository;
import com.mercadolibre.be_java_hisp_w28_g10.util.Utilities;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link IProductRepository} for managing product and post data.
 * This repository provides methods for retrieving and adding products and posts,
 * as well as initializing the repository by loading data from JSON files.
 */
@Repository
public class ProductRepositoryImpl implements IProductRepository {
    @Autowired
    private Utilities utilities;
    private List<Product> productList = new ArrayList<>();
    private List<Post> postList = new ArrayList<>();

    /**
     * Initializes the repository by loading product and post data from JSON files.
     * This method is called after the bean is constructed to populate the lists.
     *
     * @throws LoadJSONDataException if there is an error loading JSON data.
     */
    @PostConstruct
    public void init() {
        try (
                InputStream inputStream = getClass().getResourceAsStream("/products.json");
                InputStream inputStreamPost = getClass().getResourceAsStream("/post.json")) {
            productList = utilities.readValue(inputStream, new TypeReference<>() {
            });
            postList = utilities.readValue(inputStreamPost, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new LoadJSONDataException("It wasn't possible to load JSON data for Products or Post.");
        }
    }

    /**
     * {@inheritDoc}
     *
     * Retrieves all products stored in the repository.
     *
     * @return a List of {@link Product} representing all products.
     */
    @Override
    public List<Product> findAll() {
        return productList;
    }

    /**
     * {@inheritDoc}
     *
     * Retrieves all posts stored in the repository.
     *
     * @return a List of {@link Post} representing all posts.
     */
    @Override
    public List<Post> findAllPost() {
        return postList;
    }

    /**
     * {@inheritDoc}
     *
     * Checks for the existence of a product in the repository based on its ID.
     *
     * @param productId the ID of the product to check.
     * @return true if the product exists; false otherwise.
     */
    @Override
    public boolean existsProduct(int productId) {
        return productList.stream().anyMatch(product -> product.getId() == productId);
    }

    /**
     * {@inheritDoc}
     *
     * Adds a new product to the repository.
     *
     * @param product the {@link Product} to be added.
     * @return true if the product was added successfully; false if it already exists.
     */
    @Override
    public boolean addProduct(Product product) {
        return productList.add(product);
    }

    /**
     * {@inheritDoc}
     *
     * Adds a new post to the repository.
     *
     * @param post the {@link Post} to be added.
     * @return true if the post was added successfully; false if it already exists.
     */
    @Override
    public boolean addPost(Post post) {
        return postList.add(post);
    }
    /**
     * {@inheritDoc}
     *
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve.
     * @return the corresponding {@link Product} object.
     * @throws NotFoundException if the product is not found.
     */
    @Override
    public Product getProductById(int id) {
        return productList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Producto no encontrado con id: " + id));

    }
}
