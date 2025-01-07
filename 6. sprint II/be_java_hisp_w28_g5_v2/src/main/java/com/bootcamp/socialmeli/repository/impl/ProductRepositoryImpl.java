package com.bootcamp.socialmeli.repository.impl;

import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Long, Product> data = new HashMap<>();

    public Long saveProduct(Product product) {
        data.put(product.getId(), product);
        return product.getId();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }
}
