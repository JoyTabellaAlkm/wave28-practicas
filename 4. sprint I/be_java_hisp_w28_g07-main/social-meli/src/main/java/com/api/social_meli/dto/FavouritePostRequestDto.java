package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavouritePostRequestDto {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("post_id")
    private int postId;
}
