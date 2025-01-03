package com.mercadolibre.social.repository;

import com.mercadolibre.social.entity.Product;

import java.util.List;

public interface IProductRepository {
    Product findById(Integer id);

    List<Product> findProductsByQuery(String query);
}
