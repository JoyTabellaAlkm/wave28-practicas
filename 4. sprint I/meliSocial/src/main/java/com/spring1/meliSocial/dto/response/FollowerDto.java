package com.spring1.meliSocial.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowerDto {
    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String userName;
}
