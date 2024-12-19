package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserIdentificationDto {
    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String name;
}
