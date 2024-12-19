package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Product;
import com.bootcamp.socialmeli.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public boolean productExist(int idProduct) {
        return products.stream()
                .anyMatch(p -> p.getId() == idProduct);
    }

    private void loadDataBase() throws IOException {
        products = Utils.loadDataBase("products", new TypeReference<List<Product>>() {
        });
    }
}
