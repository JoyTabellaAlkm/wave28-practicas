package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void addProduct(Product product);

    boolean productExist(int idProduct);
}
