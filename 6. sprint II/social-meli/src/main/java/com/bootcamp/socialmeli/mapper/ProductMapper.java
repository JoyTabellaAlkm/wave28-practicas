package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.response.ProductDto;
import com.bootcamp.socialmeli.entity.Product;
import com.bootcamp.socialmeli.exception.BadRequestException;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {

        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setType(product.getType());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        productDto.setNotes(product.getNotes());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    public static Product mapToProduct(ProductDto product) {
        if (product == null) {
            throw new BadRequestException("Formato incorrecto");
        }
        validateProductDto(product);

        Product p = new Product();
        p.setId(product.getId());
        p.setName(product.getName());
        p.setType(product.getType());
        p.setBrand(product.getBrand());
        p.setColor(product.getColor());
        p.setNotes(product.getNotes());
        p.setPrice(product.getPrice());

        return p;
    }

    private static void validateProductDto(ProductDto product) {
        if (product.getId() <= 0) {
            throw new BadRequestException("Formato incorrecto");
        }
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new BadRequestException("Formato incorrecto");
        }
        if (product.getType() != null && product.getType().isEmpty()) {
            throw new BadRequestException("Formato incorrecto");
        }
        if (product.getBrand() != null && product.getBrand().isEmpty()) {
            throw new BadRequestException("Formato incorrecto");
        }
        if (product.getColor() != null && product.getColor().isEmpty()) {
            throw new BadRequestException("Formato incorrecto");
        }
        if (product.getNotes() != null && product.getNotes().isEmpty()) {
            throw new BadRequestException("Formato incorrecto");
        }
    }
}
