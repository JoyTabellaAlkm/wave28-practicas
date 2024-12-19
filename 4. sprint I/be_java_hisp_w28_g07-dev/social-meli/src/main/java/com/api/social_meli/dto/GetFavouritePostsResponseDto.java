package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetFavouritePostsResponseDto {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("favourite_posts")
    private List<PostDto> favouritePosts;
}
