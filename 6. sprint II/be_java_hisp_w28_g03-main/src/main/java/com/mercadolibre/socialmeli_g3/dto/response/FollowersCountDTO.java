package com.mercadolibre.socialmeli_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersCountDTO {
        @JsonProperty("user_id")
        private int userId;
        @JsonProperty("user_name")
        private String userName;
        @JsonProperty("followers_count")
        private int followersCount;
}
