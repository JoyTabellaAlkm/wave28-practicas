package com.mercadolibre.socialmeli_g3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.socialmeli_g3.dto.ProductDTO;
import com.mercadolibre.socialmeli_g3.dto.PromoProductPostDTO;
import com.mercadolibre.socialmeli_g3.entity.Post;
import com.mercadolibre.socialmeli_g3.entity.Product;
import com.mercadolibre.socialmeli_g3.entity.User;
import com.mercadolibre.socialmeli_g3.exception.BadRequestException;
import com.mercadolibre.socialmeli_g3.exception.NotFoundException;
import com.mercadolibre.socialmeli_g3.repository.IPostRepository;
import com.mercadolibre.socialmeli_g3.repository.IProductRepository;
import com.mercadolibre.socialmeli_g3.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> searchProducts(String keyword) {

        if(keyword == null || keyword.isEmpty() || keyword.length() < 3){
            throw new BadRequestException("Keyword cannot be null or less than 3 characters");
        }

        List<Product> products = productRepository.findByProductNameContaining(keyword);

        if(products.isEmpty()){
            throw new NotFoundException("Products not found");
        }

        List<ProductDTO> productDTOS = products.stream()
                .map(product -> objectMapper.convertValue(product, ProductDTO.class))
                .toList();

        return productDTOS;
    }
}
