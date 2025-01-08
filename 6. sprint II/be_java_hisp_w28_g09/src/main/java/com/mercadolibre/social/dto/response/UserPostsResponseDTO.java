package com.mercadolibre.social.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"user_id", "posts"})
public class UserPostsResponseDTO {
    @JsonProperty("user_id")
    private Integer userId;
    private List<PostDetailsDTO> posts;
}