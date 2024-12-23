package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class FollowedSellerPostsDto {
    @JsonProperty("user_id")
    private int userId;
    private List<PostDto> posts;
}
