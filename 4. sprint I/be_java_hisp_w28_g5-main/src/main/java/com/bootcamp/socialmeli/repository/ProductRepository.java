package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Long saveProduct(Product product);
}
