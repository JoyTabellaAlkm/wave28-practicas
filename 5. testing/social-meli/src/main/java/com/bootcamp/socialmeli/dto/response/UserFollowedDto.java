package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "user_name", "followed"})
public class UserFollowedDto {
    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String name;

    @JsonProperty("followed")
    private List<UserIdentificationDto> following;
}
