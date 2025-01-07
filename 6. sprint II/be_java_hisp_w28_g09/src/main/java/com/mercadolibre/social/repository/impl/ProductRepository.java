package com.mercadolibre.social.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.social.entity.Product;
import com.mercadolibre.social.exception.NotFoundException;
import com.mercadolibre.social.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private final List<Product> products;

    public ProductRepository() throws IOException {
        products = loadDataBase();
    }

    @Override
    public Product findById(Integer id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Product not found with ID: " + id));
    }

    @Override
    public List<Product> findProductsByQuery(String query) {
        if (query == null || query.trim().isEmpty()) {
            return List.copyOf(products);
        }
        return products.stream().filter(product ->
                (product.getName() != null && product.getName().trim().toLowerCase().contains(query.toLowerCase())
                        || (product.getNotes() != null && product.getNotes().trim().toLowerCase().contains(query.toLowerCase()))
                        || (product.getBrand() != null && product.getBrand().trim().toLowerCase().contains(query.toLowerCase())))
        ).toList();
    }

    private List<Product> loadDataBase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/products.json")) {
            if (inputStream == null) {
                throw new IOException("El archivo JSON no se encontró: " + "/products.json");
            }
            return objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        }
    }


}
