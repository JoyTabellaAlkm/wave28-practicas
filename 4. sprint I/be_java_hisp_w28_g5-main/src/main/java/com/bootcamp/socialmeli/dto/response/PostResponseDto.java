package com.bootcamp.socialmeli.dto.response;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
public class PostResponseDto extends PostDto {
    @JsonProperty("user_id")
    private Long userId;

    public PostResponseDto(Long id, String date, Integer category, Double price, ProductDto productDto, Long uId) {
        super(id,date,category,price,productDto);
        this.userId = uId;
    }
}
