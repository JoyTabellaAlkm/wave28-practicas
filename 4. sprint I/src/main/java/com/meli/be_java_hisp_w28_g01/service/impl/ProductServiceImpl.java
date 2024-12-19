package com.meli.be_java_hisp_w28_g01.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w28_g01.dto.request.ProductDto;
import com.meli.be_java_hisp_w28_g01.model.Product;
import com.meli.be_java_hisp_w28_g01.repository.IProductRepository;
import com.meli.be_java_hisp_w28_g01.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.getAll().stream().
                filter(product -> product.getId() == id)
                .findFirst();
    }

    @Override
    public Product add(ProductDto productDto) {
        Product product = new Product(productDto.getId(),
                productDto.getName(),
                productDto.getType(),
                productDto.getBrand(),
                productDto.getColor(),
                productDto.getNotes());
        return productRepository.add(product);
    }
}