package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FollowerCountDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("followers_count")
    private Long followersCount;
}
