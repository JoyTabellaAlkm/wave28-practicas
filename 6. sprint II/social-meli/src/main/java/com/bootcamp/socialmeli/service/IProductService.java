package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.response.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();
}
