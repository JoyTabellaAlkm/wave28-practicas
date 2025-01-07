package com.bootcamp.social_meli.repository.impl;

import com.bootcamp.social_meli.model.Product;
import com.bootcamp.social_meli.repository.IProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private final List<Product> productList = new ArrayList<>();
    private final ObjectMapper objectMapper;

    public ProductRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public Product create(Product obj) {
        productList.add(obj);
        String DATA_FILE = "src/main/resources/products.json";
        try{
            objectMapper.writeValue(new File(DATA_FILE), productList);
        }catch(IOException e){
            throw new RuntimeException("Error guardando la lista", e);
        }
        return obj;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Product delete(Product obj) {
        return null;
    }

    @Override
    public void createBatch(List<Product> products) {
        productList.addAll(products);
    }
}
