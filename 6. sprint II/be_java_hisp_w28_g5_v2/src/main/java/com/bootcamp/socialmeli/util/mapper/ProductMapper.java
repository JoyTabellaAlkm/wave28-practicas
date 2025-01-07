package com.bootcamp.socialmeli.util.mapper;

import com.bootcamp.socialmeli.dto.ProductDto;
import com.bootcamp.socialmeli.dto.request.ProductCreationDto;
import com.bootcamp.socialmeli.model.Product;

public class ProductMapper {
    private ProductMapper() {}

    public static ProductDto toProductDto(Product p) {
        return new ProductDto(
                p.getId(),
                p.getName(),
                p.getType(),
                p.getBrand(),
                p.getColor(),
                p.getNotes()
        );
    }


    public static Product toProductNew(ProductCreationDto p){
        return new Product(
                p.getId(),
                p.getName(),
                p.getType(),
                p.getBrand(),
                p.getColor(),
                p.getNotes()
        );
    }
}
