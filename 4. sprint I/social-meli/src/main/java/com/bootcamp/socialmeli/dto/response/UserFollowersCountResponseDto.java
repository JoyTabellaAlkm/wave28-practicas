package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserFollowersCountResponseDto {
    @JsonProperty("user_id")
    int id;

    @JsonProperty("user_name")
    String name;

    @JsonProperty("followers_count")
    int followersCount;
}
