package com.bootcamp.social_meli.repository;

import com.bootcamp.social_meli.model.Product;

import java.util.List;

public interface IProductRepository extends ICrudRepository<Product, Long> {
    void createBatch(List<Product> products);
}
