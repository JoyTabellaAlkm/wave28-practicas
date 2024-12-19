package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonPropertyOrder({"user_id", "posts"})
public class RecentPostsDto {
    @JsonProperty("user_id")
    int userId;
    
    List<RecentPostDto> posts;
}
