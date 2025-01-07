package com.mercadolibre.socialmeli_g3.repository;

import com.mercadolibre.socialmeli_g3.dto.ProductDTO;
import com.mercadolibre.socialmeli_g3.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    Optional<Product> findProductById(int productId);

    List<Product> findByProductNameContaining(String keyword);
}
