package com.mercadolibre.sprint1.dto.response;
import com.mercadolibre.sprint1.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsFollowedDtoResponse {
    @JsonProperty("user_id")
    int userId;
    List<PostDto> posts;
}
