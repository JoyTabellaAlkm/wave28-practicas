package com.spring1.meliSocial.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring1.meliSocial.exception.BadRequestException;
import com.spring1.meliSocial.model.Product;
import com.spring1.meliSocial.repository.IProductRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Repository
public class ProductRepository implements IProductRepository {

    private List<Product> products = new ArrayList<>();
    private String SCOPE;

    public ProductRepository() throws IOException {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/product.json");

        products = objectMapper.readValue(file,new TypeReference<List<Product>>(){});
    }


    @Override
    public Optional<Product> findId(Integer id) {
        return products.stream()
                .filter(p->p.getId()==id)
                .findFirst();
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public boolean existsProductWithId(int id) {
        return products.stream().anyMatch(p -> p.getId() == id);
    }

}
