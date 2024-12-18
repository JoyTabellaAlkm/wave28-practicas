package com.bootcamp.socialmeli.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreationDto {
    private Long user_id;
    private String date;
    private ProductCreationDto product;
    private Integer category;
    private Double price;
}
