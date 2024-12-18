package com.mercadolibre.socialmeli_g3.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.socialmeli_g3.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements IProductRepository{

    private List<Product> productsList;

    public ProductRepositoryImpl() throws IOException {
        productsList=new ArrayList<>();
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products ;

        file= ResourceUtils.getFile("classpath:productsDb.json");
        products= objectMapper.readValue(file,new TypeReference<List<Product>>(){});

        productsList = products;
    }

    @Override
    public Optional<Product> findProductById(int productId) {
        return productsList.stream().filter(p -> p.getProductId() == productId).findFirst();
    }

    @Override
    public List<Product> findByProductNameContaining(String keyword) {
        return productsList.stream()
                .filter(product -> product.getProductName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}
