package com.bootcamp.socialmeli.factory;

import com.bootcamp.socialmeli.dto.ErrorDto;
import com.bootcamp.socialmeli.dto.request.PostDto;
import com.bootcamp.socialmeli.dto.response.ProductDto;

import java.time.LocalDate;
import java.util.Arrays;

public class PostDtoFactory {

    public static PostDto newPostDtoWithoutPromoValid() {

        ProductDto productDto = new ProductDto(
                9,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red y Black",
                "Special Edition",
                0
        );

        PostDto postDto = new PostDto(
                1,
                1,
                LocalDate.now(),
                productDto,
                1,
                false,
                0.0,
                1500.50
        );

        return postDto;
    }

    public static PostDto newPostDtoWithoutPromoWithProductExists() {
        ProductDto productDto = new ProductDto(
                202,
                "Smartphone",
                "Electronics",
                "Samsung",
                "Blue",
                "Latest model",
                0
        );

        PostDto postDto = new PostDto(
                2,
                1,
                LocalDate.now(),
                productDto,
                1,
                false,
                0.0,
                1500.50
        );

        return postDto;
    }

    public static PostDto newPostDtoWithoutPromoWithNonexistentUser() {
        ProductDto productDto = new ProductDto(
                20,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red y Black",
                "Special Edition",
                0
        );

        PostDto postDto = new PostDto(
                999,
                100,
                LocalDate.now(),
                productDto,
                1,
                false,
                0.0,
                1500.50
        );

        return postDto;
    }

    public static PostDto newPostDtoWithoutPromoWithInvalidCategory() {
        ProductDto productDto = new ProductDto(
                20,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red y Black",
                "Special Edition",
                0
        );

        PostDto postDto = new PostDto(
                1,
                1,
                LocalDate.now(),
                productDto,
                100,
                false,
                0.0,
                1500.50
        );

        return postDto;
    }

    public static PostDto newPostDtoWithoutPromoWithInvalidPrice() {
        ProductDto productDto = new ProductDto(
                19,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red y Black",
                "Special Edition",
                0
        );

        PostDto postDto = new PostDto(
                1,
                1,
                LocalDate.now(),
                productDto,
                1,
                false,
                0.0,
                -1.0
        );

        return postDto;
    }

    public static PostDto newPostDtoWithPromoValid() {
        ProductDto productDto = new ProductDto(
                15,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red y Black",
                "Special Edition",
                0
        );

        PostDto postDto = new PostDto(
                2,
                1,
                LocalDate.now(),
                productDto,
                1,
                true,
                0.25,
                1500.50
        );

        return postDto;
    }

    public static PostDto newPostDtoWithoutPromoWithInvalidEntry() {
        ProductDto productDto = new ProductDto(
                -1,
                "Silla Gamer &",
                "Gamerrrrrrrrrrrrrrrrrrrrrrrrrrrrr",
                "Racer$",
                "Red & Black",
                "Special Edition",
                0
        );

        PostDto postDto = new PostDto(
                1,
                -1,
                LocalDate.now(),
                productDto,
                1,
                false,
                0,
                100000000
        );

        return postDto;
    }

    public static ErrorDto newErrorDtoInvalidEntry() {
        ErrorDto errorDto = new ErrorDto(Arrays.asList(
                new ErrorDto.ErrorDetail("product.brand", "El campo no puede poseer caracteres especiales"),
                new ErrorDto.ErrorDetail("product.name", "El campo no puede poseer caracteres especiales"),
                new ErrorDto.ErrorDetail("price", "El precio máximo por producto es de 10.000.000"),
                new ErrorDto.ErrorDetail("product.color", "El campo no puede poseer caracteres especiales"),
                new ErrorDto.ErrorDetail("product.type", "La longitud no puede superar los 15 caracteres"),
                new ErrorDto.ErrorDetail("product.id", "El id debe ser mayor a cero"),
                new ErrorDto.ErrorDetail("userId", "El id debe ser mayor a cero")
        ));

        return errorDto;
    }

    public static String newPostInvalidInput() {
        String jsonBody = """
                        {
                            "user_id": 1,
                            "post_id": 1,
                            "date": "s",
                            "product": {
                                "product_id": 20,
                                "product_name": "Wireless Mouse",
                                "type": "Electronics",
                                "brand": "Logitech",
                                "color": "Black",
                                "notes": "Ergonomic design."
                            },
                            "category": 1,
                            "price": 29.99
                        }
                
                """;

        return jsonBody;
    }


}
