package com.mercadolibre.socialmeli_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowDTO {
    @JsonProperty("user_id")
    private int userId;
    private int follower;
}
