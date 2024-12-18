package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFollowedProductsDto {
    @JsonProperty("user_id")
    Long userId;
    List<PostResponseDto> posts;
}
