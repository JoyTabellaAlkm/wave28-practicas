package com.mercadolibre.socialmeli_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.socialmeli_g3.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private int post_id;
    private int user_id;
    private String date;
    private ProductResponseDTO product;
    private int category;
    private double price;
}
