package com.api.social_meli.repository;

import com.api.social_meli.model.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
}
