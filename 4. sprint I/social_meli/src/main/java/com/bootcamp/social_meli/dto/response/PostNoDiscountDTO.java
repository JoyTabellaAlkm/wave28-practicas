package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostNoDiscountDTO {
    private Long user_id;
    private Long post_id;
    private LocalDate createDate;
    private ProductDTO product;
    private Integer category;
    private Double price;
}
