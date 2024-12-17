package com.bootcamp.socialmeli.util.validate;

import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.dto.request.ProductCreationDto;
import com.bootcamp.socialmeli.exception.BadRequestException;
import com.bootcamp.socialmeli.util.mapper.DateMapper;

import java.time.LocalDate;

public class DtoValidatorPost {
    public static void validatePostCreationReqDto(PostCreationDto postDto) {
        StringBuilder error = new StringBuilder();

        if (postDto.getUser_id() == null) {
            error.append("User ID must not be null; ");
        }

        if (postDto.getDate() == null || postDto.getDate().isEmpty() || DateMapper.toLocalDate(postDto.getDate()).isAfter(LocalDate.now())) {
            error.append("Date must not be null, empty, or greater than the current date; ");
        }

        if (postDto.getProduct() == null) {
            error.append("Product information must not be null; ");
        } else {
            validateProductCreationDto(postDto.getProduct(), error);
        }

        if (postDto.getCategory() == null || postDto.getCategory() <= 0) {
            error.append("Category must be greater than zero; ");
        }

        if (postDto.getPrice() == null || postDto.getPrice() <= 0) {
            error.append("Price must be greater than zero; ");
        }

        if (error.length() > 0) {
            throw new BadRequestException(error.toString().trim());
        }
    }

    private static void validateProductCreationDto(ProductCreationDto productDto, StringBuilder error) {
        if (productDto.getId() == null) {
            error.append("Product ID must not be null; ");
        }

        if (productDto.getName() == null || productDto.getName().isEmpty()) {
            error.append("Product name must not be null or empty; ");
        }

        if (productDto.getType() == null || productDto.getType().isEmpty()) {
            error.append("Product type must not be null or empty; ");
        }

        if (productDto.getBrand() == null || productDto.getBrand().isEmpty()) {
            error.append("Product brand must not be null or empty; ");
        }

        if (productDto.getColor() == null || productDto.getColor().isEmpty()) {
            error.append("Product color must not be null or empty; ");
        }
        if (productDto.getNotes() == null || productDto.getNotes().isEmpty()) {
            error.append("Product notes must not be null or empty; ");
        }
    }
}