package com.bootcamp.socialmeli.dto;

import com.bootcamp.socialmeli.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    @JsonProperty("post_id")
    private Long id;
    private String date;
    private Integer category;
    private Double price;
    private ProductDto product;
}
