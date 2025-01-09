package com.mercadolibre.social.repository;

import com.mercadolibre.social.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product save(Product product);

    Product findById(Integer id);

    List<Product> findProductsByQuery(String query);
}
