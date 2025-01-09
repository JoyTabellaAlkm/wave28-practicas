package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.response.ProductDto;
import com.bootcamp.socialmeli.mapper.ProductMapper;
import com.bootcamp.socialmeli.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = productRepository.findAll().stream()
                .map(p -> ProductMapper.mapToProductDto(p))
                .toList();
        return products;
    }
}
