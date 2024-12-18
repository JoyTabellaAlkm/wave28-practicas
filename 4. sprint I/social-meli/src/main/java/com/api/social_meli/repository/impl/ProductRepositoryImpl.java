package com.api.social_meli.repository.impl;

import com.api.social_meli.model.Product;
import com.api.social_meli.repository.IProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends BaseRepository<Product> implements IProductRepository {

    public ProductRepositoryImpl() {
        loadDataBase("products");
    }
}
